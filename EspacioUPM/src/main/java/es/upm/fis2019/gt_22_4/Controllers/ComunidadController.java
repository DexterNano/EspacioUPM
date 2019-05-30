package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Comunidad;
import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.Interfaces.IComunidadController;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;

import java.util.Random;

public class ComunidadController implements IComunidadController {

    private final IDataBaseController _db;

    public ComunidadController(IDataBaseController db) {
        _db = db;
    }

    public void solicitarDatosComunidad(Comunidad c)
    {

    }
    public void registrarMiembro(Usuario u, Comunidad c)
    {

    }
    public void registrarAdministrador(Usuario u,Comunidad c)
    {

    }
    public void confirmarCreacion()
    {

    }
    //AÑADIDAS POR MI
    public void crearComunidad(Comunidad c, Usuario u)
    {
        try{
            _db.connect();
            int id = new Random().nextInt();
            _db.createRow("Comunidad", id,u.getCorreo_electronico_UPM());
            c.setId(id);
            c.setNumAdministradores(1);
            c.setNumMiembros(1);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            _db.dispose();
        }
    }
}
