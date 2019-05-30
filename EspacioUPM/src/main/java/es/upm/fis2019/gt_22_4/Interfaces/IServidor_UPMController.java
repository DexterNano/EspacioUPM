package es.upm.fis2019.gt_22_4.Interfaces;

public interface IServidor_UPMController {
    void comprobarValidezCorreo(String correo);
    boolean notificarValidezCorreo();
    boolean validarRegistro();
    boolean denegarRegistro();
}
