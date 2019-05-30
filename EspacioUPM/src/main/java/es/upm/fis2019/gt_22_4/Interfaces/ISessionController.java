package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Usuario;

public interface ISessionController {
    Usuario login(String correo, String contraseña);
    void logout();
}
