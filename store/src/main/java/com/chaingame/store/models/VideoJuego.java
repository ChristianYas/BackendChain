package com.chaingame.store.models;

import java.util.List;

public class VideoJuego {
    
    int idVideoJuego;
    String desarrollado; 
    String clasificacion;
    String genero; 
    String  trailer; 
    Producto producto;
    List<Foto> listaFotos;

    public VideoJuego(){}

    public VideoJuego(int idVideoJuego, String desarrollado, String clasificacion, String genero, String trailer,
            Producto producto, List<Foto> listaFotos) {
        this.idVideoJuego = idVideoJuego;
        this.desarrollado = desarrollado;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.trailer = trailer;
        this.producto = producto;
        this.listaFotos = listaFotos;
    }
    


    public int getIdVideoJuego() {
        return idVideoJuego;
    }
    public void setIdVideoJuego(int idVideoJuego) {
        this.idVideoJuego = idVideoJuego;
    }
    public String getDesarrollado() {
        return desarrollado;
    }
    public void setDesarrollado(String desarrollado) {
        this.desarrollado = desarrollado;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getTrailer() {
        return trailer;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public List<Foto> getListaFotos() {
        return listaFotos;
    }
    public void setListaFotos(List<Foto> listaFotos) {
        this.listaFotos = listaFotos;
    }



}
