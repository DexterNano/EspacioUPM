package es.upm.fis2019.gt_22_4.Domain;

public class Publicacion_Tipo_Referencia extends Publicacion {
    private Publicacion publicacion_referenciada;
    private Usuario usuarioReferenciado;

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
}
