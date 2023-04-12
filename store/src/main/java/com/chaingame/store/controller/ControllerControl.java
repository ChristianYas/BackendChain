package com.chaingame.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.chaingame.store.Connection.ConnectionMySQL;
import com.chaingame.store.models.Consola;
import com.chaingame.store.models.Control;
import com.chaingame.store.models.Foto;
import com.chaingame.store.models.Producto;

public class ControllerControl {

    public List<Control> getAll(String plataform, String filter) throws Exception{

        List<Control> listVideoJuegos = new ArrayList<>();

        String sql = consultaGet(plataform, filter);

        Connection con = new ConnectionMySQL().getConnection();

        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            listVideoJuegos.add(fill(rs));
        }

        return listVideoJuegos;

    }

    public Control fill(ResultSet rs) throws Exception{


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

        Control c = new Control();

        c.setIdControl(rs.getInt(10));
        c.setInalambrico(rs.getBoolean(11));
        c.setColor(rs.getString(12));
        c.setConectoresDeEntrada(rs.getString(13));
        c.setVibracion(rs.getBoolean(14));
        c.setBluetooth(rs.getBoolean(15));
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

        String sql = "SELECT * FROM vista_control";

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
