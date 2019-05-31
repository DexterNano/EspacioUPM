package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Administrador_de_comunidad;
import es.upm.fis2019.gt_22_4.Domain.Comentario;
import es.upm.fis2019.gt_22_4.Domain.Publicacion;
import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.System.UsuarioSystem;

public interface IUsuarioController {
    void logIn(Usuario u);
    void logOut();
    void ingresarCredenciales();
    void restaurarContraseña(String n_contraseña);

    void seguirUsuario(Usuario u1,Usuario u2);
    void dejardeseguirUsuario(Usuario u,Usuario u2);

    void darLike(Usuario u,Publicacion p); //ATRIBUTO ¿PUBLICACION?
    void darDislike(Usuario u,Publicacion p);
    void comentar(Publicacion p, Comentario c);
    Comentario[] consultarComentarios(Publicacion p);  //RETURN ¿ARRAY?
    void publicar(Usuario u, Publicacion p);
    void referenciarPublicacion(Usuario u,Publicacion p);
    Publicacion seleccionarPublicacion(Publicacion p);
    Publicacion seleccionarTipoPublicacion(Publicacion p);
    void mostrar_publicaciones(Usuario u);
    Usuario buscarUser(String user);
    void mostrar_timeline(Usuario u);
    boolean[] checkSeguimiento(Usuario u1,Usuario u2);

    void borrarActividad(Usuario u);
    void darsedeBaja(Usuario u);
    void confirmarBorrado(Usuario u);

    void crearComunidad(Usuario u);
    void rellenarDatosComunidad(Administrador_de_comunidad admin,Integer nm, Integer na);

    void escribirEnBorrador();
    void publicarBorrador();
}
