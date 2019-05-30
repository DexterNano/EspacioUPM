package es.upm.fis2019.gt_22_4.Interfaces;

import java.util.ArrayList;

public interface IDataBaseController {
    void addTable(String name, Object[] columns, String primary, Object[] foreign);
    void ensureCreated();
    void connect();
    void dispose();

    void createRow(String table, Object... args) throws Exception;

    //ArrayList<Object[]> readRow(String table, Tuple<String, Object>[] wheres, String elements) throws Exception;
    ArrayList<Object[]> readRow(String table, Object[] wheres, String elements) throws Exception;

    //void updateRow(String table, Tuple<String, Object>[] wheres, String[] columns, Object... args) throws Exception;
    void updateRow(String table, Object[] wheres, String[] columns, Object... args) throws Exception;

    //void deleteRow(String table, Tuple<String, Object>[] wheres) throws Exception;
    void deleteRow(String table, Object[] wheres) throws Exception;
}
