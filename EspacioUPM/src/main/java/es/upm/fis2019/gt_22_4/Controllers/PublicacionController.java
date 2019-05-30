package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Comentario;
import es.upm.fis2019.gt_22_4.Domain.Publicacion;
import es.upm.fis2019.gt_22_4.Interfaces.IPublicacionController;

public class PublicacionController implements IPublicacionController
{
    public Publicacion generarBorrador()
    {
        Publicacion aux = new Publicacion();
        return aux;
    }
    public Publicacion mostrarPublicacion()
    {
        Publicacion aux = new Publicacion();
        return aux;
    }
    public void mostrarPantallaSeleccionTipoPublicacion()
    {

    }
    public Comentario[] mostrarComentarios()
    {
        Comentario aux[] = new Comentario[1];
        return aux;
    }
    public void borrarPublicaciones()
    {

    }
}
