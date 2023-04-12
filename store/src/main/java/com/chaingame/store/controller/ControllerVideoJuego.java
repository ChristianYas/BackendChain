package com.chaingame.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.chaingame.store.Connection.ConnectionMySQL;
import com.chaingame.store.models.Foto;
import com.chaingame.store.models.Producto;
import com.chaingame.store.models.VideoJuego;

public class ControllerVideoJuego {
    
    public List<VideoJuego> getAll(String plataform, String filter) throws Exception{

        List<VideoJuego> listVideoJuegos = new ArrayList<>();

        String sql = consultaGet(plataform, filter);

        Connection con = new ConnectionMySQL().getConnection();

        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            listVideoJuegos.add(fill(rs));
        }

        return listVideoJuegos;

    }

    public VideoJuego fill(ResultSet rs) throws Exception{

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

        VideoJuego vj = new VideoJuego();

        vj.setIdVideoJuego(rs.getInt(10));
        vj.setDesarrollado(rs.getString(11));
        vj.setClasificacion(rs.getString(12));
        vj.setGenero(rs.getString(13));
        vj.setTrailer(rs.getString(14));
        vj.setProducto(p);

        return vj;
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

        String sql = "SELECT * FROM vista_videoJuego";

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
