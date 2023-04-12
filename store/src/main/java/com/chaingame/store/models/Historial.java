package com.chaingame.store.models;

public class Historial {
    
    int idCarrito;
    String fecha;
    int idCliente;
    Producto producto;
    int cantidad;
    int comprado;
    int onCar;

    public Historial(){}

    public Historial(int idCarrito, String fecha, int idCliente, Producto producto, int cantidad, int comprado, int onCar) {
        this.idCarrito = idCarrito;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.producto = producto;
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
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setComprado(int comprado){
        this.comprado = comprado;
    }

    public int getComprado(){
        return comprado;
    }


    public int getOnCar(){
        return onCar;
    }
    public void setOnCar(int onCar){
        this.onCar = onCar;
    }
}
