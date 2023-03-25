package com.chaingame.store.models;

import java.util.List;

public class Consola {
    
    int idConsola;
    String almacenamiento; 
    boolean control;
    String resolucion; 
    String ram; 
    String tipoDeMemoria; 
    Producto producto;
    List<Foto> listaFotos;

    public Consola(){}

    public Consola(int idConsola, String almacenamiento, boolean control, String resolucion, String ram,
            String tipoDeMemoria, Producto producto, List<Foto> listaFotos) {
        this.idConsola = idConsola;
        this.almacenamiento = almacenamiento;
        this.control = control;
        this.resolucion = resolucion;
        this.ram = ram;
        this.tipoDeMemoria = tipoDeMemoria;
        this.producto = producto;
        this.listaFotos = listaFotos;
    }

    public int getIdConsola() {
        return idConsola;
    }
    public void setIdConsola(int idConsola) {
        this.idConsola = idConsola;
    }
    public String getAlmacenamiento() {
        return almacenamiento;
    }
    public void setAlmacenamiento(String almaenamiento) {
        this.almacenamiento = almaenamiento;
    }
    public boolean isControl() {
        return control;
    }
    public void setControl(boolean control) {
        this.control = control;
    }
    public String getResolucion() {
        return resolucion;
    }
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    public String getRam() {
        return ram;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }
    public String getTipoDeMemoria() {
        return tipoDeMemoria;
    }
    public void setTipoDeMemoria(String tipoDeMemoria) {
        this.tipoDeMemoria = tipoDeMemoria;
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
