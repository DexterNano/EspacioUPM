package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Comentario;
import es.upm.fis2019.gt_22_4.Domain.Publicacion;

public interface IPublicacionController {
    Publicacion generarBorrador();
    Publicacion mostrarPublicacion();
    void mostrarPantallaSeleccionTipoPublicacion();
    Comentario[] mostrarComentarios();                  //CONSULTAR SI ESTO ES UN ARRAY
    void borrarPublicaciones();                         //ATRBUTO ¿PUBLICACION?
}
