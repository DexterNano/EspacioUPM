package es.upm.fis2019.gt_22_4.Domain;

public class Administrador_de_comunidad extends Usuario//CREO QUE ESTO NO DEBERIA EXISTIR, SOLO EXISTE AQUI Y EN EL DIAGRAMA DE DEPLOYMENT
{
    public Administrador_de_comunidad(Usuario u) {
        super(u.getCorreo_electronico_UPM(),u.getContrasenia(),u.getAlias());
    }
}
