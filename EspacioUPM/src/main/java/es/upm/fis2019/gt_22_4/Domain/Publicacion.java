package es.upm.fis2019.gt_22_4.Domain;

import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public abstract class Publicacion {
    protected Integer num_likes;
    protected Integer num_dislikes;
    protected Usuario creador;
    protected Integer id_p;
    protected Date fecha;
    protected Integer tipo;//NUEVA COSA AÑADIDA

    //¿COMENTARIOS?

    public Publicacion(Usuario creador)
    {
        this.num_likes=0;
        this.num_dislikes=0;
        this.creador=creador;
        fecha=null;
    }
    public Publicacion()
    {
        this.num_likes=0;
        this.num_dislikes=0;
        this.creador=null;
        fecha=null;
    }
    public Publicacion Publicacion(Integer tipo)
    {
        Publicacion publi=null;
        if(tipo==1)
            publi=new Publicacion_Tipo_Texto();
        else if(tipo==2)
            publi=new Publicacion_Tipo_Enlace();
        else
            publi=new Publicacion_Tipo_Referencia();
        return publi;
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
    public Integer getTipo(){return tipo;}

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
    public void setId_pub(Integer id){this.id_p =id;}
    public void setId_p(IDataBaseController db){
        try {
            db.connect();
            ArrayList<Object[]> rows = db.readRow("Publicacion", new Object[]{"*"} //HE QUITADO UNA COMA QUE PARECIA INNECESARIA.
            , "id_u,date", null, null, null);
            this.id_p =rows.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract String AString();
    public abstract String getContenido();
    public abstract void setcontenido(String s);
}
