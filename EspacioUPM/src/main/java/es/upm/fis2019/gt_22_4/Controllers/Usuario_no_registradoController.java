package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Usuario_no_registrado;
import es.upm.fis2019.gt_22_4.Interfaces.IUsuario_no_registradoController;

public class Usuario_no_registradoController implements IUsuario_no_registradoController
{
    public boolean darsedeAlta(Usuario_no_registrado newUser){
        return false;
    }
    public void introducirAlias(String alias){

    }
    public int introducirContraseña2veces(){
        return 0;
    }
}
