package es.upm.fis2019.gt_22_4.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Publicacion_Tipo_Enlace extends Publicacion {
    private String resumen;
    private String titulo;
    private String imagen;

    public Publicacion_Tipo_Enlace(Usuario creador)
    {
        super(creador);
        this.resumen="";
        this.titulo="";
        this.imagen="";
    }
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

    public void setPublicacion(Object[] aux) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
        this.creador=new Usuario();
        this.creador.setCorreo_electronico_UPM(aux[0].toString());
        this.titulo=aux[1].toString();
        this.resumen=aux[2].toString();
        this.imagen=aux[3].toString();
        try {
            this.fecha = date.parse(aux[4].toString());
        }catch (ParseException e){
            e.printStackTrace();
        }
        this.num_likes=Integer.parseInt(aux[5].toString());
        this.num_dislikes=Integer.parseInt(aux[6].toString());
    }

    public String AString()
    {
        return "";
    }

}
