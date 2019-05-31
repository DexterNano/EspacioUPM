package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.*;
import es.upm.fis2019.gt_22_4.Interfaces.IComentarioController;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IPublicacionController;
import es.upm.fis2019.gt_22_4.Interfaces.IUsuarioController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioController implements IUsuarioController {

    protected IDataBaseController _db;

    public UsuarioController(IDataBaseController db)
    {
        _db=db;
    }

    public void logIn(Usuario u)
    {

    }
    public void logOut()
    {

    }
    public void ingresarCredenciales()
    {

    }
    public void restaurarContraseña(String n_contraseña)
    {

    }
    public void seguirUsuario(Usuario u1,Usuario u2)
    {

    }
    public void dejardeseguirUsuario(Usuario u1,Usuario u2)
    {

    }
    public void darLike(Usuario u,Publicacion p)
    {

    }
    public void darDislike(Usuario u,Publicacion p)
    {

    }
    public void comentar(Publicacion p, Comentario c)
    {
    }
    public void consultarComentarios(Publicacion p){
        Comentario comentarios[]=null;
        IUsuarioController userController = new UsuarioController(_db);
        IPublicacionController publiContoller=new PublicacionController(_db);
        IComentarioController comentariocontroller=new ComentarioController(_db);
        boolean esteBien;
        boolean noVermas=false;
        boolean end=false;
        Integer contador=0;
        Scanner sc =new Scanner(System.in);
        while (!noVermas) {
            esteBien=false;
            System.out.println("-----------------------------------------------");
            System.out.println("  Comentarios " + contador + "-" + (contador + 49));
            System.out.println("  ");
            System.out.println("-----------------------------------------------");
            try {
                _db.connect();
                comentarios = new Comentario[50];
                ArrayList<Object[]> rows = _db.readRow("Comentario", new Object[]{
                        new Tupla<String, Object>("publicacion", p.getId_p())
                }, "publicacion,Num_orden", null, null, null);
                for (int i = 0; i < rows.size(); i++) {
                    Object[] aux = rows.get(i);
                    comentarios[i].setNum_orden((Integer) aux[1]);
                    comentarios[i].getComentada().setId_p(_db);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                _db.dispose();
            }
            for(int i=0;i<comentarios.length;i++)
            {
                comentariocontroller.mostrarComentario(comentarios[i],p);
            }
            while(!esteBien) {
                int opcion=0;
                System.out.println("----------------------------------------");
                System.out.println("1. Seleccionar un comentario");
                if(!end)
                    System.out.println("2. ver siguiente pagina");
                if(contador>0)
                    System.out.println("3. ver anterior pagina");
                System.out.println("0. Salir al menu principal");
                System.out.println("----------------------------------------");
                System.out.println("Elija una opcion: ");
                opcion=sc.nextInt();
                try {
                    switch (opcion){
                        case 0:
                            esteBien=true;
                            noVermas=true;
                            break;
                        case 1:
                            esteBien=true;
                            noVermas=true;
                            int numero;
                            System.out.println("Introduzca el numero del comentario a seleccionar: ");
                            numero=sc.nextInt();
                            if(comentarios[numero]!=null)
                                userController.seleccionarComentario(comentarios[numero],p);
                            else System.out.println("No existe esa publicacion");
                            break;
                        case 2:
                            esteBien=true;
                            contador+=50;
                            break;
                        case 3:
                            esteBien=true;
                            contador-=50;
                            break;
                        default:
                            System.out.println("Debe ser un numero entre el 0 y el 3"); //CAMBIAR NUMERO
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    sc.next();
                }
            }
        }
    }
    public void publicar(Usuario u,Publicacion p)
    {

    }
    public void referenciarPublicacion(Usuario u,Publicacion p)
    {

    }
    public void borrarActividad(Usuario u)
    {

    }
    public void darsedeBaja(Usuario u)
    {

    }
    public void confirmarBorrado(Usuario u)
    {

    }
    public void crearComunidad(Usuario admin)
    {

    }
    public void rellenarDatosComunidad(Administrador_de_comunidad admin, Integer nm, Integer na)
    {

    }
    public void seleccionarPublicacion(Publicacion p, Usuario u)
    {
        System.out.println(p.AString());
    }
    public void seleccionarComentario(Comentario c,Publicacion p)
    {
        System.out.println(c.AString());
    }
    public Publicacion seleccionarTipoPublicacion(Publicacion p)
    {
        return new Publicacion_Tipo_Enlace(new Usuario());
    }
    public void escribirEnBorrador()
    {

    }
    public void publicarBorrador()
    {

    }
    public void mostrar_publicaciones(Usuario u) {
        Publicacion publicaciones[]=null;
        IUsuarioController userController = new UsuarioController(_db);
        IPublicacionController publiContoller=new PublicacionController(_db);
        boolean esteBien;
        boolean noVermas=false;
        boolean end=false;
        Integer contador=0;
        Scanner sc =new Scanner(System.in);
        while (!noVermas) {
            esteBien=false;
            System.out.println("-----------------------------------------------");
            System.out.println("  Publicaciones " + contador + "-" + (contador + 49));
            System.out.println("  Perfil: " + u.getCorreo_electronico_UPM());
            System.out.println("-----------------------------------------------");
            try {
                _db.connect();
                publicaciones = new Publicacion[50];
                ArrayList<Object[]> rows = _db.readRow("Publicacion", new Object[]{
                        new Tupla<String, Object>("id_u", u.getCorreo_electronico_UPM())  //HE QUITADO UNA COMA QUE PARECIA INNECESARIA.
                }, "id_u,date,id_Pub,contenido,referenciada,tipo", "date", contador.toString(), "50");
                for (int i = 0; i < rows.size(); i++) {
                    if((Integer) rows.get(i)[5]==1){
                        publicaciones[i]=new Publicacion_Tipo_Texto();
                        publicaciones[i].setcontenido((String) rows.get(i)[3]);

                    }
                    else if ((Integer) rows.get(i)[5]==2){
                        publicaciones[i]=new Publicacion_Tipo_Enlace();
                        publicaciones[i].setcontenido((String) rows.get(i)[3]);
                    }
                    else{
                        publicaciones[i]=new Publicacion_Tipo_Referencia();
                    }
                    publicaciones[i].setId_pub((Integer) rows.get(i)[2]);
                    publicaciones[i].setCreador(u);
                    publiContoller.mostrarPublicacion(publicaciones[i],u);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                _db.dispose();
            }
            for(int i=0;i<publicaciones.length;i++)
            {
                if(publicaciones[i]!=null)
                    publiContoller.mostrarPublicacion(publicaciones[i],u);
            }
            while(!esteBien) {
                int opcion=0;
                System.out.println("----------------------------------------");
                System.out.println("1. Seleccionar una publicacion");
                if(!end)
                    System.out.println("2. ver siguiente pagina");
                if(contador>0)
                    System.out.println("3. ver anterior pagina");
                System.out.println("0. Salir al menu principal");
                System.out.println("----------------------------------------");
                System.out.println("Elija una opcion: ");
                opcion=sc.nextInt();
                try {
                    switch (opcion){
                        case 0:
                            esteBien=true;
                            noVermas=true;
                            break;
                        case 1:
                            esteBien=true;
                            noVermas=true;
                            int numero;
                            System.out.println("Introduzca el numero de la publicacion a seleccionar: ");
                            numero=sc.nextInt();
                            if(publicaciones[numero]!=null)
                                userController.seleccionarPublicacion(publicaciones[numero],u);
                            else System.out.println("No existe esa publicacion");
                            break;
                        case 2:
                            esteBien=true;
                            contador+=50;
                            break;
                        case 3:
                            esteBien=true;
                            contador-=50;
                            break;
                        default:
                            System.out.println("Debe ser un numero entre el 0 y el 3"); //CAMBIAR NUMERO
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    sc.next();
                }
            }
        }
    }
    public Usuario buscarUser(String alias)
    {
        Usuario user=null;
        try{
            _db.connect();
            ArrayList<Object[]> rows = _db.readRow("Usuario", new Object[]{
                    new Tupla<String, Object>("alias", alias)
            }, "correo,alias,pass", null, null, null);
            if(rows.size()==1)
            {
                String mail =(String) rows.get(0)[0];
                String aliasAUX = (String) rows.get(0)[1];
                String pass = (String) rows.get(0)[2];
                user = new Usuario(mail,pass,aliasAUX);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            _db.dispose();
        }
        return user;
    }
    public boolean[] checkSeguimiento(Usuario u1,Usuario u2)
    {
        boolean resul[]={false,false};
        try{
            _db.connect();
            ArrayList<Object[]> rows = _db.readRow("Seguimiento",
                    new Object[]{new Tupla<String,Object>("correo_seguidor",u1.getCorreo_electronico_UPM())
                    , new Tupla<String,Object>("correo_seguido",u2.getCorreo_electronico_UPM())},
                    "correo_seguidor, correo_seguido",null,null,null);
            if(rows.size()==1)
                resul[0]=true;
            rows=_db.readRow("Seguimiento",
                    new Object[]{new Tupla<String,Object>("correo_seguido",u1.getCorreo_electronico_UPM())
                            , new Tupla<String,Object>("correo_seguidor",u2.getCorreo_electronico_UPM())},
                    "correo_seguidor, correo_seguido",null,null,null);
            if(rows.size()==1)
                resul[1]=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            _db.dispose();
        }
        return resul;
    }
    public void mostrar_timeline(Usuario u) {

    }


}
