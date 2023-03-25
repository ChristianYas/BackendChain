package com.chaingame.store.models;

public class Historial {
    
    int idCarrito;
    String fecha;
    int idCliente;
    Producto producto;

    public Historial(){}

    public Historial(int idCarrito, String fecha, int idCliente, Producto producto) {
        this.idCarrito = idCarrito;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.producto = producto;
    }

    public int getIdCarrito() {
        return idCarrito;
    }
    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }



}
