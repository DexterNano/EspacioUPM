package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Comentario;
import es.upm.fis2019.gt_22_4.Domain.Publicacion;
import es.upm.fis2019.gt_22_4.Interfaces.IComentarioController;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;

public class ComentarioController implements IComentarioController {
    private IDataBaseController _db;

    public ComentarioController(IDataBaseController db) {
        _db = db;
    }

    public void borrarComentarios(String n_orden)
    {

    }
    public void mostrarComentario(Comentario c, Publicacion p)
    {

    }
}
