package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.*;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IPublicacionController;
import es.upm.fis2019.gt_22_4.Interfaces.IUsuarioController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PublicacionController implements IPublicacionController
{
    protected IDataBaseController _db;

    public PublicacionController(IDataBaseController db){
        _db=db;
    }
    public Publicacion generarBorrador(Usuario u)
    {
        Publicacion publicacion=null;
        IPublicacionController publicontroller=new PublicacionController(_db);
        IUsuarioController usuariocontroller = new UsuarioController(_db);
        Scanner sc=new Scanner(System.in);
        Integer op;
        boolean terminado=false;
        while(!terminado) {
            this.mostrarPantallaSeleccionTipoPublicacion();
            System.out.println();
            System.out.println("Escoja una de las opciones: ");
            op = sc.nextInt();
            try {
                switch (op) {
                    case 1:
                        publicacion=new Publicacion_Tipo_Texto(u);
                        usuariocontroller.publicar(u,publicacion);
                        terminado = true;
                        break;
                    case 2:
                        publicacion=new Publicacion_Tipo_Enlace(u);
                        usuariocontroller.publicar(u,publicacion);
                        terminado = true;
                        break;
                    case 3:
                        terminado = true;
                        break;
                    default:
                        System.out.println("Deben ser numeros entre el 1 y el 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
        return publicacion;
    }
    public void mostrarPublicacion(Publicacion p, Usuario u)
    {
        IPublicacionController publicacioncontroller=new PublicacionController(_db);
        Scanner sc = new Scanner(System.in);
        Integer op;
        System.out.println(p.AString());
        System.out.println();
        System.out.println("1. Mostrar cometarios.");
        if(p.getCreador().equals(u))
            System.out.println("2. Borrar Publicacion.");
        System.out.println();
        System.out.println("Escoger una opcion: ");
        op=sc.nextInt();
        try{
            switch (op)
            {
                case 1:

                    break;
                case 2:
                    if(p.getCreador().equals(u))
                        publicacioncontroller.borrarPublicaciones(u,p);
                    break;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void mostrarPantallaSeleccionTipoPublicacion()
    {
        System.out.println("-------------------------------------");
        System.out.println("1. Publicacion de tipo texto");
        System.out.println("2. Publicacion de tipo enlace");
        System.out.println("3. Cancelar");
        System.out.println("-------------------------------------");
    }
    public Comentario[] mostrarComentarios()
    {
        Comentario aux[] = new Comentario[1];
        return aux;
    }
    public void borrarPublicaciones(Usuario u,Publicacion p)
    {
        try {
            _db.connect();
            _db.deleteRow("Publicacion",new Object[]{
                    new Tupla<String, Object>("id_u", u.getCorreo_electronico_UPM()),
                    new Tupla<String, Object>("id_Pub", u.getAlias())
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void publicar(Usuario u, Publicacion p) {
        try{
            _db.connect();
            if(p.getTipo()==3)
                _db.createRow("Publicacion",u.getCorreo_electronico_UPM(),p.getId_p(), Timestamp.valueOf(LocalDateTime.now()),p.getContenido(),p.getId_p(),p.getTipo());
            else
                _db.createRow("Publicacion",u.getCorreo_electronico_UPM(),p.getId_p(), Timestamp.valueOf(LocalDateTime.now()),p.getContenido(),-1,p.getTipo());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _db.dispose();
        }
    }
}
