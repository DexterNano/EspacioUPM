package es.upm.fis2019.gt_22_4.Domain;

public class Publicacion_Tipo_Referencia extends Publicacion {
    private Publicacion publicacion_referenciada;
    private Usuario usuarioReferenciado;

    public Publicacion_Tipo_Referencia(Usuario creador) {
        super(creador);
        super.tipo=3;
    }
    public Publicacion_Tipo_Referencia()
    {
        super();
        tipo=3;
    }

    public Publicacion getPublicacion_referenciada() {
        return publicacion_referenciada;
    }
    public Usuario getUsuarioReferenciado() {
        return usuarioReferenciado;
    }

    public void setPublicacion_referenciada(Publicacion publicacion_referenciada) {
        this.publicacion_referenciada = publicacion_referenciada;
    }
    public void setUsuarioReferenciado(Usuario usuarioReferenciado) {
        this.usuarioReferenciado = usuarioReferenciado;
    }


    public String AString()
    {
        String resultado="";
        resultado+="------------------------------------------------\n";
        resultado+="         @"+super.creador.getAlias()+"\n\n";
        resultado+="        "+publicacion_referenciada.AString();
        resultado+="\n";
        resultado+="Likes: "+super.num_likes+"    Dislikes: "+ super.num_dislikes+"\n";
        resultado+="------------------------------------------------\n";
        return resultado;
    }
    public String getContenido()
    {
        return "";
    }

    @Override
    public void setcontenido(String s) {}
}
