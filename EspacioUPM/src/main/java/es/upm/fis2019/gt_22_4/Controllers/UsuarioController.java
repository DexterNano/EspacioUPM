package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.*;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IPublicacionController;
import es.upm.fis2019.gt_22_4.Interfaces.IUsuarioController;

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
    public Comentario[] consultarComentarios(Publicacion p){
        Comentario aux[] = new Comentario[1];
        return aux;
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
    public Publicacion seleccionarPublicacion(Publicacion p)
    {
        return new Publicacion_Tipo_Enlace(new Usuario());
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
                        new Tupla<String, Object>("correo", u.getCorreo_electronico_UPM())  //HE QUITADO UNA COMA QUE PARECIA INNECESARIA.
                }, "creador,fecha", "date", contador.toString(), "50");
                for (int i = 0; i < rows.size(); i++) {
                    Object[] aux = rows.get(i);
                    publicaciones[i].setPublicacion(aux);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                _db.dispose();
            }
            for(int i=0;i<publicaciones.length;i++)
            {
                publiContoller.mostrarPublicacion(publicaciones[i]);
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
                                userController.seleccionarPublicacion(publicaciones[numero]);
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
