package es.upm.fis2019.gt_22_4.Domain;

public class Publicacion {
    private Integer num_likes;
    private Integer num_dislikes;

    //¿COMENTARIOS?

    public Integer getNum_dislikes() {
        return num_dislikes;
    }
    public Integer getNum_likes() {
        return num_likes;
    }

    public void setNum_dislikes(Integer num_dislikes) {
        this.num_dislikes = num_dislikes;
    }
    public void setNum_likes(Integer num_likes) {
        this.num_likes = num_likes;
    }
}
