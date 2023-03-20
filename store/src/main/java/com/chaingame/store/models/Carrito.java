package com.chaingame.store.models;

public class Carrito {
    
    int idCarrito;
    String fecha;
    int idcliente;
    int idProducto;

    public Carrito(){}

    public Carrito(int idCarrito, String fecha, int idcliente, int idProducto) {
        this.idCarrito = idCarrito;
        this.fecha = fecha;
        this.idcliente = idcliente;
        this.idProducto = idProducto;
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
    public int getIdcliente() {
        return idcliente;
    }
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    

}
