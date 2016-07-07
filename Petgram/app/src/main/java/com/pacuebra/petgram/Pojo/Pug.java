package com.pacuebra.petgram.Pojo;

/**
 * Created by Francisco on 26/06/2016.
 */
public class Pug {

    private String calif;
    private int foto;
    private int hueso;


    public Pug (int foto, String calif, int hueso){
       this.foto=foto;
        this.calif=calif;
        this.hueso=hueso;
    }

    public String getCalif() {
        return calif;
    }

    public void setCalif(String calif) {
        this.calif = calif;
    }

    public int getHueso() {
        return hueso;
    }

    public void setHueso(int hueso) {
        this.hueso = hueso;
    }


    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    }
