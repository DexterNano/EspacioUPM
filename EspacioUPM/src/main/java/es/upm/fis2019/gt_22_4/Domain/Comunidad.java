package es.upm.fis2019.gt_22_4.Domain;

public class Comunidad {
    private Integer NumMiembros;
    private Integer NumAdministradores;
    private String TimeLine;              //REVISAR SI ES UN STRING
    private Integer id;

    public Integer getNumMiembros() {
        return NumMiembros;
    }
    public Integer getNumAdministradores() {
        return NumAdministradores;
    }
    public String getTimeLine() {
        return TimeLine;
    }
    public Integer getId() {
        return id;
    }

    public void setNumAdministradores(Integer numAdministradores) {
        NumAdministradores = numAdministradores;
    }
    public void setNumMiembros(Integer numMiembros) {
        NumMiembros = numMiembros;
    }
    public void setTimeLine(String timeLine) {
        TimeLine = timeLine;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
