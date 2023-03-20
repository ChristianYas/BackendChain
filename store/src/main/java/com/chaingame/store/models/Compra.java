package com.chaingame.store.models;

public class Compra {
    
    int idCompra;
    int cantidad;
    float precioUnitario; 
    float latitud; 
    float longitud;
    int idCarrito;
    String fecha;

    public Compra(){}

    public Compra(int idCompra, int cantidad, float precioUnitario, float latitud, float longitud, int idCarrito,
            String fecha) {
        this.idCompra = idCompra;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.idCarrito = idCarrito;
        this.fecha = fecha;
    }

    public int getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public float getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public float getLatitud() {
        return latitud;
    }
    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }
    public float getLongitud() {
        return longitud;
    }
    public void setLongitud(float longitud) {
        this.longitud = longitud;
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


}
