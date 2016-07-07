package com.pacuebra.petgram.Pojo;

/**
 * Created by Francisco on 14/06/2016.
 */
public class Perro {
    private String nombre;
    private int foto;
 //   private int bthueso;
    private int btlike;
    private int id;
    private int likes;

    public Perro(int foto, String nombre, /*int bthueso,*/ int btlike, int likes){
        this.nombre = nombre;
        this.foto = foto;
       // this.bthueso= bthueso;
        this.likes = likes;
    }

    public Perro() {
    }

    /*
    public int getBthueso() {
        return bthueso;
    }

    public void setBthueso(int bthueso) {
        this.bthueso = bthueso;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getBtlike() {
        return btlike;
    }

    public void setBtlike(int btlike) {
        this.btlike = btlike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
