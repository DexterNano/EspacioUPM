package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Domain.Tupla;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class DatabaseController implements IDataBaseController {
    //private String property = System.getProperty("user.dir");
    private String property = System.getProperty("user.dir");
    private boolean isClosed;      //check if databased is closed
    private Connection connection;

    private final Hashtable<String, TableDefinition> _tables;

    private static Object[] toArray(String... values)
    {
        if (values.length % 2 == 1) throw new IllegalArgumentException("number of values must be even!");
        int total = values.length / 2;
        Object[] arr = new Object[total];

        for (int i = 0; i < values.length; i += 2) {
            arr[i/2] = new Tupla<String,String>(values[i], values[i + 1]);
        }

        return arr;
    }

    private class TableDefinition
    {
        public String[] Colums;
        public String[] ColumTypes;
        public String PrimaryKey;
        public Object[] ForeignKeys;
    }

    public DatabaseController(){
        _tables = new Hashtable<>();
        isClosed=true;
    }

    public void addTable(String name, Object[] columns, String primary, Object[] foreign) {
        TableDefinition def = new TableDefinition();

        def.Colums = new String[columns.length];
        def.ColumTypes = new String[columns.length];
        def.PrimaryKey = primary;
        if (foreign != null)
            def.ForeignKeys = foreign;
        else def.ForeignKeys = new Object[0];

        for (int i = 0; i < columns.length; i++) {
            Tupla<String, String> tuple = (Tupla<String, String>) columns[i];
            def.Colums[i] = tuple.x;
            def.ColumTypes[i] = tuple.y;
        }
        _tables.put(name, def);
    }

    public void ensureCreated() {
        try {
            for (Map.Entry<String, TableDefinition> entry : _tables.entrySet()) {
                StringBuilder columns = new StringBuilder();
                StringBuilder foreignKeys = new StringBuilder();
                TableDefinition def = entry.getValue();

                for (int i = 0; i < def.Colums.length; i++) {
                    columns.append(String.format("%s %s NOT NULL, ", def.Colums[i], def.ColumTypes[i]));
                }

                for (int i = 0; i < def.ForeignKeys.length; i++) {
                    if (i == 0) foreignKeys.append(", ");
                    Tupla<String, String> tuple = (Tupla<String, String>) def.ForeignKeys[i];
                    foreignKeys.append(String.format("FOREIGN KEY(%s) REFERENCES %s", tuple.x, tuple.y));
                    if (i < def.ForeignKeys.length - 1)
                        foreignKeys.append(", ");
                }
                String query = String.format("CREATE TABLE IF NOT EXISTS %s (" +
                                "%s " +
                                "PRIMARY KEY(%s)" +
                                "%s" +
                                ")",
                        entry.getKey(), // Table name
                        columns.toString(),
                        def.PrimaryKey,
                        foreignKeys.toString()
                );

                connection.prepareStatement(query).executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeResources();

        }
    }

    public void connect() {
        if(!isClosed)
            return;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + property + "/EspacioUPM.db", "", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dispose() {
        closeResources();
    }

    public void createRow(String table, Object... args) throws SQLException {
        String[] qmarks = new String[args.length];
        Arrays.fill(qmarks, "?");

        String query;

        if (!_tables.containsKey(table)) {
            query = String.format("INSERT INTO %s VALUES (%s)",
                    table,
                    String.join(",", qmarks)
            );
        } else {
            TableDefinition t = _tables.get(table);

            String[] cols = new String[args.length];
            int offset = t.Colums.length - args.length;

            for (int i = 0; i < args.length; i++) {
                cols[i] = t.Colums[i + offset];
            }

            query = String.format("INSERT INTO %s (%s) VALUES (%s)",
                    table,
                    String.join(",", cols),
                    String.join(",", qmarks)
            );
        }
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < args.length; i++) {
            setParameter(statement, i + 1, args[i]);
        }
        statement.executeUpdate();
    }

    private void setParameter(PreparedStatement statement, int pos, Object val) throws SQLException {
        if (val instanceof Date) {
            statement.setDate(pos, new java.sql.Date(((Date)val).getTime()));
            // No preserva la zona horaria! Cuidado!
            // Es mejor un timestamp.
        } else {
            statement.setObject(pos, val);
        }
    }


    public ArrayList<Object[]> readRow(String table, Object[] wheres, String elements, String orden, String inicio, String numer) throws SQLException {
        String[] whereClauses = new String[wheres.length];
        String[] cols = elements.split(",");

        for (int i = 0; i < wheres.length; i++) {
            whereClauses[i] = ((Tupla<String, Object>)wheres[i]).x + " = ? ";
        }

        String query = String.format("SELECT %s FROM %s WHERE %s",
                elements,
                table,
                String.join(" AND ", whereClauses)
        );
        if(orden!=null)
            query.join(" ORDER BY ",orden);
        if(inicio!=null && numer!=null) {
            query.join(" LIMIT ", inicio);
            query.join(", ",numer);
        }
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < wheres.length; i++) {
            setParameter(statement, i + 1, ((Tupla<String, Object>)wheres[i]).y);
        }

        ResultSet results = statement.executeQuery();
        ArrayList<Object[]> outputs = new ArrayList<>();

        while (results.next()) {
            Object[] cout = new Object[cols.length];
            for (int i = 0; i < cols.length; i++) {
                cout[i] = results.getObject(cols[i]);
            }

            outputs.add(cout);
        }

        return outputs;
    }

    public void updateRow(String table, Object[] wheres, String[] columns, Object... args) throws SQLException {
        for (int i = 0; i < columns.length; i++) {
            columns[i] = columns[i] + " = ?";
        }

        String[] whereClauses = new String[wheres.length];

        for (int i = 0; i < wheres.length; i++) {
            whereClauses[i] = ((Tupla<String, Object>)wheres[i]).x + " = ? ";
        }

        String query = String.format("UPDATE %s SET %s WHERE %s",
                table,
                String.join(", ", columns),
                String.join(" AND ", whereClauses)
        );

        PreparedStatement statement = connection.prepareStatement(query);


        for (int i = 0; i < args.length; i++) {
            setParameter(statement, i + 1, args[i]);
        }

        for (int i = 0; i < wheres.length; i++) {
            setParameter(statement, i + 1 + args.length, ((Tupla<String, Object>)wheres[i]).y);
        }

        statement.executeUpdate();
    }

    public void deleteRow(String table, Object[] wheres) throws SQLException {
        String[] whereClauses = new String[wheres.length];

        for (int i = 0; i < wheres.length; i++) {
            whereClauses[i] = ((Tupla<String, Object>)wheres[i]).x + " = ? ";
        }

        String query = String.format("DELETE FROM %s WHERE %s",
                table,
                String.join(" AND ", whereClauses)
        );

        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < wheres.length; i++) {
            setParameter(statement, i + 1, ((Tupla<String, Object>)wheres[i]).y);
        }

        statement.executeUpdate();
    }

    public static void addDefaultTables(IDataBaseController controller){
        controller.addTable("Comunidad", toArray("NumMiembros","INTEGER","NumAdministradores","INTEGER","Id_C","INTEGER"),"Id_C",toArray());
        controller.addTable("Usuario",toArray("correo","TEXT","alias","TEXT","pass","TEXT"),"correo",toArray());
        controller.addTable("Publicacion",toArray("id_u","TEXT","id_Pub","INTEGER","date","DATETIME","contenido","TEXT","referenciada","INTEGER"),"id_Pub",toArray("id_u","Usuario"));
        controller.addTable("Comentario",toArray("Num_orden","INTEGER","publicacion","INTEGER","usuario","TEXT"),"publicacion, Num_orden",toArray("publicacion","Publicacion","usuario","Usuario"));
        //controller.addTable("PublicacionReferencia",toArray("Publicacion_Referenciada","INTEGER","Usuario_Referenciado","TEXT","id_Pub","INTEGER"),"id_Pub",toArray("id_Pub","Publicacion"));
        //controller.addTable("PublicacionEnlace",toArray("id_Pub","INTEGER","resumen","TEXT","titulo","TEXT","imagen","TEXT"),"id_Pub",toArray("id_Pub","Publicacion"));
        //controller.addTable("PublicacionTexto",toArray("id_Pub","INTEGER","texto","TEXT","num_Caracteres","INTEGER"),"id_Pub",toArray("id_Pub","Publicacion"));
        controller.addTable("Seguimiento",toArray("correo_seguidor","TEXT","correo_seguido","TEXT"),"correo_seguidor, correo_seguido",toArray("correo_seguidor","Usuario","correo_seguido","Usuario"));
    }

    void closeResources () {
        try {
            if (!isClosed) {
                this.connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            isClosed = true;
        }
    }
}
