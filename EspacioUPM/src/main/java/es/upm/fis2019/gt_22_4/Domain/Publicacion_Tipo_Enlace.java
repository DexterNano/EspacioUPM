package es.upm.fis2019.gt_22_4.Domain;

public class Publicacion_Tipo_Enlace extends Publicacion {
    private String resumen;
    private String titulo;
    private String imagen;

    public String getResumen() {
        return resumen;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getImagen() {
        return imagen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
