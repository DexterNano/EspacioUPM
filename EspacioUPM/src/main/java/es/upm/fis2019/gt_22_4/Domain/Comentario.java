package es.upm.fis2019.gt_22_4.Domain;

public class Comentario {
    private Integer num_orden;
    private String texto;
    private Publicacion comentada;

    public Integer getNum_orden() {
        return num_orden;
    }
    public String getTexto() {
        return texto;
    }
    public Publicacion getComentada() {
        return comentada;
    }

    public void setNum_orden(Integer num_orden) {
        this.num_orden = num_orden;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public void setComentada(Publicacion comentada) {
        this.comentada = comentada;
    }

    public String AString() {
        String resul="";
        resul+="-------------------------\n";
        resul+="  "+texto;
        resul+="\n-------------------------\n";
        return resul;
    }
}
