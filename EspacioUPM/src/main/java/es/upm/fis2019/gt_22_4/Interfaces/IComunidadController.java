package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Comunidad;
import es.upm.fis2019.gt_22_4.Domain.Usuario;

public interface IComunidadController
{
     void solicitarDatosComunidad(Comunidad c);
     void registrarMiembro(Usuario u, Comunidad c);
     void registrarAdministrador(Usuario u,Comunidad c);
     void confirmarCreacion();
}
