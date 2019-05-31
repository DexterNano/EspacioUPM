package es.upm.fis2019.gt_22_4.Controllers;

import es.upm.fis2019.gt_22_4.Domain.Publicacion;
import es.upm.fis2019.gt_22_4.Domain.Usuario;
import es.upm.fis2019.gt_22_4.Interfaces.IDataBaseController;
import es.upm.fis2019.gt_22_4.Interfaces.IPublicacion_Tipo_ReferenciaController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Publicacion_Tipo_ReferenciaController extends PublicacionController implements IPublicacion_Tipo_ReferenciaController
{
    public Publicacion_Tipo_ReferenciaController(IDataBaseController db) {
        super(db);
    }

    public void borrarReferenciasaPublicaciones()
    {

    }
    public void publicar(Usuario u, Publicacion p1, Publicacion p2) {
        try{
            _db.connect();
            _db.createRow("Publicacion",u.getCorreo_electronico_UPM(),p1.getId_p(), Timestamp.valueOf(LocalDateTime.now()),null,p2.getId_p());
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            _db.dispose();
        }
    }
}
