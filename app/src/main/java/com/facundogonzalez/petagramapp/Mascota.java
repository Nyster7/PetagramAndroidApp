package com.facundogonzalez.petagramapp;

public class Mascota {
    private int foto;
    private String nombre;
    private int likes;

    public Mascota(int foto, String nombre,int likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes = likes;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        foto = foto;
    }

    public int getLikes() {return likes;}

    public void setLikes(int likes) {this.likes = likes;}

}
