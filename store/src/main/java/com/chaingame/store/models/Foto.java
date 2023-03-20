package com.chaingame.store.models;

public class Foto {
    
    int idFoto;
    String foto;
    int idProducto;

    public Foto(){}

    public Foto(int idFoto, String foto, int idProducto) {
        this.idFoto = idFoto;
        this.foto = foto;
        this.idProducto = idProducto;
    }

    public int getIdFoto() {
        return idFoto;
    }
    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }



}
