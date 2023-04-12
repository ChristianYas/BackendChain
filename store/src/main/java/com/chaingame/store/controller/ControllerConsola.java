package com.chaingame.store.controller;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.chaingame.store.Connection.ConnectionMySQL;
import com.chaingame.store.models.Consola;
import com.chaingame.store.models.Foto;
import com.chaingame.store.models.Producto;

public class ControllerConsola {

    public List<Consola> getAll(String plataform, String filter) throws Exception{

        List<Consola> listConsolas = new ArrayList<>();

        String sql = consultaGet(plataform, filter);

        Connection con = new ConnectionMySQL().getConnection();

        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            listConsolas.add(fill(rs));
        }

        return listConsolas;

    }

    public Consola fill(ResultSet rs) throws Exception{


        Producto p = new Producto();

        p.setIdProducto(rs.getInt(1));
        p.setTitulo(rs.getString(2));
        p.setPrecio(rs.getFloat(3));
        p.setCondicion(rs.getString(4));
        p.setPlataforma(rs.getString(5));
        p.setGarantia(rs.getString(6));
        p.setDescripcion(rs.getString(7));
        p.setPublicador(rs.getString(8));
        p.setLanzamiento(rs.getString(9));
        p.setListaFotos(getPhotos(rs.getInt(1)));

        Consola c = new Consola();

        c.setIdConsola(rs.getInt(10));
        c.setAlmacenamiento(rs.getString(11));
        c.setControl(rs.getBoolean(12));
        c.setResolucion(rs.getString(13));
        c.setRam(rs.getString(14));
        c.setTipoDeMemoria(rs.getString(15));
        c.setProducto(p);

        return c;

    }

    public List<Foto> getPhotos(int idProducto) throws Exception{

        List<Foto> fotos = new ArrayList<>();

        String sql = "SELECT * FROM foto WHERE idProducto = ?";

        Connection con = new ConnectionMySQL().getConnection();

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, idProducto);

        ResultSet rs = pstmt.executeQuery();

       while(rs.next()){

            Foto foto = new Foto(rs.getInt(1), rs.getString(2), rs.getInt(3));

            fotos.add(foto);

       }

        return fotos;
    }
    
    public String consultaGet(String plataform, String filter){

        String sql = "SELECT * FROM vista_consola";

        if(plataform.equals("0")){

            if(!filter.equals("0")){
                sql += " WHERE titulo LIKE '%" + filter + "%'"; 
            }

                    
        }else{
            sql += " WHERE plataforma LIKE '%" + plataform + "%'";

            if(!filter.equals("0")){
                sql += " AND titulo LIKE '%" + filter + "%'"; 
            }
        }

        return sql;

    }
}
