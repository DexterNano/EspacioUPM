package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Tupla;
import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IPasswordHasher;
import es.upm.fis2019.gt_22_4.Interfaces.IRegistrerController;

import java.util.ArrayList;

public class RegisterController implements IRegistrerController {
    private final IDataBaseController _db;
    private final IPasswordHasher _hasher;

    public RegisterController(IDataBaseController db, IPasswordHasher hasher) {
        _db = db;
        _hasher = hasher;
    }


    public synchronized boolean register (Usuario user) throws Exception
    {
        try {
            _db.connect();
            ArrayList<Object[]> rows = _db.readRow("Usuario", new Object[] { 
                new Tupla<String, Object>("correo", user.getCorreo_electronico_UPM()),
			}, "correo");

            if (rows.size() > 0) { // Ya se ha registrado
                return false;
            } else {
                _db.createRow("Usuario", user.getCorreo_electronico_UPM(), _hasher.hash(user.getContrasenia()));
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            _db.dispose();
        }
        return false;
    }
}