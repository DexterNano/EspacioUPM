package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Comentario;
import es.upm.fis2019.gt_22_4.Domain.Publicacion;
import es.upm.fis2019.gt_22_4.Domain.Usuario;

public interface IPublicacionController {
    Publicacion generarBorrador(Usuario u);
    void mostrarPublicacion(Publicacion p);
    void mostrarPantallaSeleccionTipoPublicacion();
    Comentario[] mostrarComentarios();                  //CONSULTAR SI ESTO ES UN ARRAY
    void borrarPublicaciones(Usuario u,Publicacion p);  //ATRBUTO ¿PUBLICACION?
    void publicar(Usuario u ,Publicacion p);
}
