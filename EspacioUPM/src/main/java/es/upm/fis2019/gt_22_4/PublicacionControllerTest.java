package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class PublicacionControllerTest {

//No sabemos instanciar lo necesario asi que suponemos u y u2 como usuarios con publicaciones...etc

    @Test
    public void generarBorrador() {

        assertEquals(generarBorrador(u),generarBorrador(u2));
        //habria que instanciar el borrador
    }

    @Test
    public void mostrarPublicacion() {

        assertEquals(mostrarPublicacion(u),mostrarPublicacion(u2));

    }

    @Test
    public void mostrarPantallaSeleccionTipoPublicacion() {
        assertEquals(mostrarPantallaSeleccionTipoPublicacion(u),mostrarPantallaSeleccionTipoPublicacion(u2));

    }

    @Test
    public void mostrarComentarios() {
        assertEquals(mostrarComentarios(u),mostrarComentarios(u2));

    }

    @Test
    public void borrarPublicaciones() {
        assertEquals(borrarPublicaciones(u),borrarPublicaciones(u2));

    }

    @Test
    public void publicar() {
    }
}
