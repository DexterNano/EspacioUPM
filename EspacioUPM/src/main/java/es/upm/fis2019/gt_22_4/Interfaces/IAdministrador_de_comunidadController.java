package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Comunidad;
import es.upm.fis2019.gt_22_4.Domain.Usuario;

public interface IAdministrador_de_comunidadController {
    void eliminarComunidad(Comunidad c);
    void validarIncorporacion(Usuario u, Comunidad c);
    void expulsarUsuario(Usuario u);
    void darPermisos(Usuario u);
    void quitarPermisos(Usuario u);
}
