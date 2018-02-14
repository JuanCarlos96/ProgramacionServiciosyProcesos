package Tema3.EjExtra10_TCP;

import java.io.Serializable;

public class Departamento implements Serializable{
    private String iddep;
    private float media;

    public Departamento(String iddep) {
        this.iddep = iddep;
    }

    public String getIddep() {
        return iddep;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
}