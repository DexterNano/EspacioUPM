package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IPasswordHasher;
import es.upm.fis2019.gt_22_4.Interfaces.ISessionController;


public class SessionController implements ISessionController {
    private final IDataBaseController _db;
    private final IPasswordHasher _hasher;

    public SessionController(IDataBaseController db, IPasswordHasher hasher) {
        _db = db;
        _hasher = hasher;
    }

    public Usuario login(String correo, String contraseña) {
        Usuario user = null;

        try {
            _db.connect();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            _db.dispose();
        }
        return user;
    }

    public void logout() {
       //Decir al servidor que quite al usuario de conectados y desconectar conexion del Socket
    }
}
