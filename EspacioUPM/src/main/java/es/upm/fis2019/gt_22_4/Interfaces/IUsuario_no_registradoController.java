package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Usuario_no_registrado;

public interface IUsuario_no_registradoController {
    boolean darsedeAlta(Usuario_no_registrado newUser); //CAMBIE EL BOOLEAN
    int introducirContraseña2veces(); //NO SE QUE DEBE DEVOLVER
}
