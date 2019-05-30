package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Comunidad;
import es.upm.fis2019.gt_22_4.Domain.Usuario;

public interface IAdministrador_de_comunidadController {
    public void eliminarComunidad(Comunidad c);
    public void validarIncorporacion(Usuario u, Comunidad c);
    public void expulsarUsuario(Usuario u);
    public void darPermisos(Usuario u);
    public void quitarPermisos(Usuario u);
}
