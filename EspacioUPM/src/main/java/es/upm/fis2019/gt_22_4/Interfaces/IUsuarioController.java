package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Comentario;
import es.upm.fis2019.gt_22_4.Domain.Publicacion;
import es.upm.fis2019.gt_22_4.Domain.Usuario;

public interface IUsuarioController {
    void logIn(Usuario u);
    void logOut();
    void modificarAlias(String a);
    void ingresarCredenciales();
    void restaurarContraseña(String n_contraseña);
    void seguirUsuario(Usuario u);
    void dejardeseguirUsuario(Usuario u);
    void darLike(); //ATRIBUTO ¿PUBLICACION?
    void darDislike();
    void comentar(Publicacion p, Comentario c);
    void verUsuario(Usuario u); //RETURN ¿USUARIO?
    Comentario[] consultarComentarios();  //RETURN ¿ARRAY?
    void publicar(Publicacion p);
    void referenciarPublicacion(Publicacion p);
    void borrarActividad();
    void darsedeBaja(Usuario u);
    void confirmarBorrado();
    void crearComunidad();
    void rellenarDatosComunidad(Integer nm,Integer na);
    void irAPerfil(Usuario i);
    void seleccionarPublicacion(Publicacion p);
    void seleccionarTipoPublicacion(Publicacion p);
    void escribirEnBorrador();
    void publicarBorrador();
}
