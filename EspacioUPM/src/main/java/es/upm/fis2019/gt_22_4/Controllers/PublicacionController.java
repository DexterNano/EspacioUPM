package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.*;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IPublicacionController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PublicacionController implements IPublicacionController
{
    private IDataBaseController _db;

    public PublicacionController(IDataBaseController db){
        db=_db;
    }
    public Publicacion generarBorrador(Usuario u)
    {
        Publicacion publicacion=null;
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
                        terminado = true;
                        break;
                    case 2:
                        publicacion=new Publicacion_Tipo_Enlace(u);
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
    public void mostrarPublicacion(Publicacion p)
    {
        System.out.println("-----------------------------------");
        System.out.println("@"+p.getCreador().getAlias());
        System.out.println(p.AString());
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

    }
}
