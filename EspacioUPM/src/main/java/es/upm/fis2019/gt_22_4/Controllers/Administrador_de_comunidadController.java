package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Comunidad;
import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.Interfaces.IAdministrador_de_comunidadController;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;

import java.util.IdentityHashMap;

public class Administrador_de_comunidadController extends UsuarioController implements IAdministrador_de_comunidadController //VER SI EL EXTENDS ES EN CONTROLLER O EN ADMINISTRADOR
{

    public Administrador_de_comunidadController(IDataBaseController db) {
        super(db);
    }

    public void eliminarComunidad(Comunidad c)
    {

    }
    public void validarIncorporacion(Usuario u, Comunidad c)
    {

    }
    public void expulsarUsuario(Usuario u)
    {

    }
    public void darPermisos(Usuario u)
    {

    }
    public void quitarPermisos(Usuario u)
    {

    }
}
