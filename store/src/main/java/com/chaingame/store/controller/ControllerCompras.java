package com.chaingame.store.controller;

import com.chaingame.store.Connection.ConnectionMySQL;
import com.chaingame.store.models.Carrito;
import com.chaingame.store.models.Historial;
import com.chaingame.store.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerCompras {
    

    public void addShoppingCar(Carrito carrito) throws Exception{
        
        Connection con = new ConnectionMySQL().getConnection();

        String sql = "CALL InsertarCarrito(?, ?, ?)";

        CallableStatement cstmt = con.prepareCall(sql);

        cstmt.setString(1, carrito.getFecha());
        cstmt.setInt(2, carrito.getIdcliente());
        cstmt.setInt(3, carrito.getIdProducto());

        cstmt.execute();
    }

    public List<Historial> getAllCarritos(String idCliente) throws Exception{

        List<Historial> listaHistorial = new ArrayList<>();

        Connection con = new ConnectionMySQL().getConnection();

        String sql = "SELECT * FROM vista_carrito WHERE idCliente = ' " + idCliente + " '";

        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery(sql);

        while(rs.next()){

            listaHistorial.add(fill(rs));

        }

        return listaHistorial;
        

    }

    public Historial fill(ResultSet rs) throws Exception{


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

        Historial h = new Historial();

        h.setIdCarrito(rs.getInt(10));
        h.setFecha(rs.getString(11));
        h.setIdCliente(rs.getInt(12));
        h.setProducto(p);

        return h;

    }

}
