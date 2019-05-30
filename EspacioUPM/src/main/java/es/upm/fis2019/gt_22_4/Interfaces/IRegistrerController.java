package es.upm.fis2019.gt_22_4.Interfaces;

import es.upm.fis2019.gt_22_4.Domain.Usuario;

public interface IRegistrerController {
    boolean register(Usuario user) throws Exception;
}
