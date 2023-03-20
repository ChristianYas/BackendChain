package com.chaingame.store.models;

public class Producto {
 
    int idProducto;
    String titulo;
    float precio;
    String condicion; 
    String plataforma; 
    String garantia;
    String descripcion; 
    String publicador; 
    String lanzamiento;

    public Producto(){}

    public Producto(int idProducto, String titulo, float precio, String condicion, String plataforma, String garantia,
            String descripcion, String publicador, String lanzamiento) {
        this.idProducto = idProducto;
        this.titulo = titulo;
        this.precio = precio;
        this.condicion = condicion;
        this.plataforma = plataforma;
        this.garantia = garantia;
        this.descripcion = descripcion;
        this.publicador = publicador;
        this.lanzamiento = lanzamiento;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getCondicion() {
        return condicion;
    }
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public String getGarantia() {
        return garantia;
    }
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getPublicador() {
        return publicador;
    }
    public void setPublicador(String publicador) {
        this.publicador = publicador;
    }
    public String getLanzamiento() {
        return lanzamiento;
    }
    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    } 


}
