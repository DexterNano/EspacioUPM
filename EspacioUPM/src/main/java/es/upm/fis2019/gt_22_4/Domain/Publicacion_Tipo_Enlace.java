package es.upm.fis2019.gt_22_4.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Publicacion_Tipo_Enlace extends Publicacion {
    private String resumen;
    private String titulo;
    private String imagen;
    private String url;

    public Publicacion_Tipo_Enlace(Usuario creador)
    {
        super(creador);
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la direccion web: ");
        url= sc.nextLine();
        this.resumen="";
        this.titulo="";
        this.imagen="";
        super.tipo=2;
    }
    public Publicacion_Tipo_Enlace(){
        super();
        this.resumen="";
        this.titulo="";
        this.imagen="";
        this.url="";
        super.tipo=2;
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
    public String getUrl(){return url;}

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String AString()
    {
        String resultado="";
        resultado+="------------------------------------------------\n";
        resultado+="         @"+super.creador.getAlias()+"\n\n";
        resultado+="titulo: "+this.titulo+"\n";
        resultado+="resumen: "+this.resumen+"\n";
        resultado+="imagen: "+this.imagen+"\n";
        resultado+="\n";
        resultado+="Likes: "+super.num_likes+"    Dislikes: "+ super.num_dislikes+"\n";
        resultado+="------------------------------------------------\n";
        return resultado;
    }
    public String getContenido()
    {
        return this.getUrl();
    }

    @Override
    public void setcontenido(String s) {
        url=s;
    }

}
