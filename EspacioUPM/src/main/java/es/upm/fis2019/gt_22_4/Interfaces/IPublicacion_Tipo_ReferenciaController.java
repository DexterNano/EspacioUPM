package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Publicacion;
import es.upm.fis2019.gt_22_4.Domain.Usuario;

public interface IPublicacion_Tipo_ReferenciaController
{
    void borrarReferenciasaPublicaciones();
    void publicar(Usuario u, Publicacion p1,Publicacion p2);
}
