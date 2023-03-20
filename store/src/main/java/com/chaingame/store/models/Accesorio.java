package com.chaingame.store.models;

import java.util.List;

public class Accesorio {
    
    int idAccesorio;
    String material;
    int idProducto;
    Producto producto;
    List<Foto> listFotos;

    public Accesorio(){}

    public Accesorio(int idAccesorio, String material, int idProducto, Producto producto, List<Foto> listFotos) {
        this.idAccesorio = idAccesorio;
        this.material = material;
        this.idProducto = idProducto;
        this.producto = producto;
        this.listFotos = listFotos;
    }

    public int getIdAccesorio() {
        return idAccesorio;
    }
    public void setIdAccesorio(int idAccesorio) {
        this.idAccesorio = idAccesorio;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
