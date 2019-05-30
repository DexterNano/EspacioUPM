package es.upm.fis2019.gt_22_4.Domain;

public class Usuario extends Usuario_no_registrado {
    private String Correo_electronico_UPM;
    private String Contrasenia;
    private Publicacion[] Publicaciones; //REVISAR SI ESTO ES ARRAY
    private Usuario seguidores;         //REVISAR SI ES UN ARRAY.
    private Usuario seguidos;           //REVISAR SI ES UN ARRAY.
    private String Historial_de_actividades;    //CONFIRMAR TIPO DE ELEMENTO.

    public Usuario(String correo_electronico,String pass)
    {
        Correo_electronico_UPM=correo_electronico;
        Contrasenia=pass;
    }

    public Publicacion[] getPublicaciones() {
        return Publicaciones;
    }
    public String getContrasenia() {
        return Contrasenia;
    }
    public String getCorreo_electronico_UPM() {
        return Correo_electronico_UPM;
    }
    public String getHistorial_de_actividades() {
        return Historial_de_actividades;
    }
    public Usuario getSeguidores() {
        return seguidores;
    }
    public Usuario getSeguidos() {
        return seguidos;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }
    public void setCorreo_electronico_UPM(String correo_electronico_UPM) {
        Correo_electronico_UPM = correo_electronico_UPM;
    }
    public void setPublicaciones(Publicacion[] publicaciones) {
        Publicaciones = publicaciones;
    }
    public void setSeguidores(Usuario seguidores) {
        this.seguidores = seguidores;
    }
    public void setSeguidos(Usuario seguidos) {
        this.seguidos = seguidos;
    }
    public void setHistorial_de_actividades(String historial_de_actividades) {
        Historial_de_actividades = historial_de_actividades;
    }
}