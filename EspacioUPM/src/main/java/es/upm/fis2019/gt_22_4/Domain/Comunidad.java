package es.upm.fis2019.gt_22_4.Domain;

import java.util.ArrayList;

public class Comunidad {
    private Integer NumMiembros;
    private Integer NumAdministradores;
    private ArrayList<Publicacion> TimeLine;              //REVISAR SI ES UN STRING
    private Integer id_C;

    public Integer getNumMiembros() {
        return NumMiembros;
    }
    public Integer getNumAdministradores() {
        return NumAdministradores;
    }
    public ArrayList<Publicacion> getTimeLine() {
        return TimeLine;
    }
    public Integer getId() {
        return id_C;
    }

    public void setNumAdministradores(Integer numAdministradores) {
        NumAdministradores = numAdministradores;
    }
    public void setNumMiembros(Integer numMiembros) {
        NumMiembros = numMiembros;
    }
    public void setTimeLine(ArrayList<Publicacion> timeLine) {
        TimeLine = timeLine;
    }
    public void setId(Integer id) {
        this.id_C = id;
    }
}
