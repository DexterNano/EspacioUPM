package es.upm.fis2019.gt_22_4.Domain;

import java.util.Scanner;

public class Publicacion_Tipo_Texto extends Publicacion
{
    private String texto;
    private Integer numero_de_caracteres;

    public Publicacion_Tipo_Texto(Usuario creador) {
        super(creador);
        Scanner sc = new Scanner(System.in);
        boolean verdadero=false;
        while (!verdadero) {
            System.out.println("Escriba el texto: ");
            texto = sc.nextLine();
            numero_de_caracteres = texto.length();
            if (numero_de_caracteres > 140)
                System.out.println("El texto es demasiado largo");
            else
                verdadero=true;
        }
        super.tipo=1;
    }
    public Publicacion_Tipo_Texto()
    {
        texto="";
        numero_de_caracteres=texto.length();
        tipo=1;
    }

    public String getTexto() {
        return texto;
    }
    public Integer getNumero_de_caracteres() {
        return numero_de_caracteres;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public void setNumero_de_caracteres(Integer numero_de_caracteres) {
        this.numero_de_caracteres = numero_de_caracteres;
    }

    public String AString()
    {
        String resultado="";
        resultado+="------------------------------------------------\n";
        resultado+="         @"+super.creador.getAlias()+"\n\n";
        resultado+="   "+this.texto+"\n";
        resultado+="\n";
        resultado+="Likes: "+super.num_likes+"    Dislikes: "+ super.num_dislikes+"\n";
        resultado+="------------------------------------------------\n";
        return resultado;
    }
    public String getContenido()
    {
        return this.getTexto();
    }

    @Override
    public void setcontenido(String s) {
        texto=s;
    }
}
