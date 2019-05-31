package es.upm.fis2019.gt_22_4.Domain;

public class Publicacion_Tipo_Texto extends Publicacion
{
    private String texto;
    private Integer numero_de_caracteres;

    public Publicacion_Tipo_Texto(Usuario creador) {
        super(creador);
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

    public void setPublicacion(Object[] aux)
    {

    }

    public String AString()
    {
        return "";
    }
}
