package com.chaingame.store.models;

public class Carrito {
    
    int idCarrito;
    String fecha;
    int idCliente;
    int idProducto;
    int cantidad;
    int comprado;
    int onCar;

    public Carrito(){}

    public Carrito(int idCarrito, String fecha, int idCliente, int idProducto, int cantidad, int comprado, int onCar) {
        this.idCarrito = idCarrito;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.comprado = comprado;
        this.onCar = onCar;
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
    public void setIdcliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public int getComprado(){
        return comprado;
    }
    public void setComprado(int comprado){
        this.comprado = comprado;
    }

    public int getOnCar(){
        return onCar;
    }
    public void setOnCar(int onCar){
        this.onCar = onCar;
    }
}
