package es.upm.fis2019.gt_22_4.Domain;

import java.text.ParseException;
import java.util.Date;

public abstract class Publicacion {
    protected Integer num_likes;
    protected Integer num_dislikes;
    protected Usuario creador;
    protected Integer id_p;
    protected Date fecha;          //NUEVA COSA AÑADIDA

    //¿COMENTARIOS?

    public Publicacion(Usuario creador)
    {
        this.num_likes=0;
        this.num_dislikes=0;
        this.creador=creador;
        fecha=null;
    }

    public Integer getNum_dislikes() {
        return num_dislikes;
    }
    public Integer getNum_likes() {
        return num_likes;
    }
    public Usuario getCreador() {
        return creador;
    }
    public Date getFecha(){
        return fecha;
    }
    public Integer getId_p(){return id_p;}

    public void setNum_dislikes(Integer num_dislikes) {
        this.num_dislikes = num_dislikes;
    }
    public void setNum_likes(Integer num_likes) {
        this.num_likes = num_likes;
    }
    public void setCreador(Usuario creador) {
        this.creador = creador;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setId_p(Integer id){this.id_p = id;}

    public abstract void setPublicacion(Object[] aux) throws ParseException;
    public abstract String AString();
}
