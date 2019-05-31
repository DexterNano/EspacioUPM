package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Comentario;
import es.upm.fis2019.gt_22_4.Domain.Publicacion;

public interface IComentarioController
{
    public void borrarComentarios(String n_orden); //n_orden DEBERIA SER INTEGER

    void mostrarComentario(Comentario comentario, Publicacion p);
}
