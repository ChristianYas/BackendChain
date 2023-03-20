package com.chaingame.store.models;

import java.util.List;

public class Consola {
    
    int idConsola;
    String memoria; 
    boolean control;
    String resolucion; 
    String capacidad; 
    String tipoDeMemoria; 
    Producto producto;
    List<Foto> listFotos;

    public Consola(){}

    public Consola(int idConsola, String memoria, boolean control, String resolucion, String capacidad,
            String tipoDeMemoria, Producto producto, List<Foto> listFotos) {
        this.idConsola = idConsola;
        this.memoria = memoria;
        this.control = control;
        this.resolucion = resolucion;
        this.capacidad = capacidad;
        this.tipoDeMemoria = tipoDeMemoria;
        this.producto = producto;
        this.listFotos = listFotos;
    }

    public int getIdConsola() {
        return idConsola;
    }
    public void setIdConsola(int idConsola) {
        this.idConsola = idConsola;
    }
    public String getMemoria() {
        return memoria;
    }
    public void setMemoria(String memoria) {
        this.memoria = memoria;
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
    public String getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
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
    public List<Foto> getListFotos() {
        return listFotos;
    }
    public void setListFotos(List<Foto> listFotos) {
        this.listFotos = listFotos;
    }


}
