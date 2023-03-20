package com.chaingame.store.models;

import java.util.List;

public class Control {

    int idControl;
    boolean inalambrico; 
    String color;  
    String conectoresDeEntrada; 
    boolean vibracion; 
    boolean bluetooth; 
    Producto producto;
    List<Foto> listFotos;

    public Control(){}

    public Control(int idControl, boolean inalambrico, String color, String conectoresDeEntrada, boolean vibracion,
            boolean bluetooth, Producto producto, List<Foto> listFotos) {
        this.idControl = idControl;
        this.inalambrico = inalambrico;
        this.color = color;
        this.conectoresDeEntrada = conectoresDeEntrada;
        this.vibracion = vibracion;
        this.bluetooth = bluetooth;
        this.producto = producto;
        this.listFotos = listFotos;
    }

    public int getIdControl() {
        return idControl;
    }
    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }
    public boolean isInalambrico() {
        return inalambrico;
    }
    public void setInalambrico(boolean inalambrico) {
        this.inalambrico = inalambrico;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getConectoresDeEntrada() {
        return conectoresDeEntrada;
    }
    public void setConectoresDeEntrada(String conectoresDeEntrada) {
        this.conectoresDeEntrada = conectoresDeEntrada;
    }
    public boolean isVibracion() {
        return vibracion;
    }
    public void setVibracion(boolean vibracion) {
        this.vibracion = vibracion;
    }
    public boolean isBluetooth() {
        return bluetooth;
    }
    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
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
