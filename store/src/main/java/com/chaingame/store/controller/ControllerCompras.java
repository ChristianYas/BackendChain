package com.chaingame.store.controller;

import com.chaingame.store.Connection.ConnectionMySQL;
import com.chaingame.store.models.Carrito;
import com.chaingame.store.models.Compra;
import com.chaingame.store.models.Foto;
import com.chaingame.store.models.Historial;
import com.chaingame.store.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerCompras {

    public String addShoppingCar(Carrito carrito) throws Exception {

        Boolean verificate = false;
        Connection con = new ConnectionMySQL().getConnection();

        String sql = "CALL InsertarCarrito(?, ?, ?, ?)";

        CallableStatement cstmt = con.prepareCall(sql);

        cstmt.setString(1, carrito.getFecha());
        cstmt.setInt(2, carrito.getIdCliente());
        cstmt.setInt(3, carrito.getIdProducto());
        cstmt.setInt(4, carrito.getCantidad());

        cstmt.execute();
        verificate = true;
        return verificate.toString();
    }

    public String addCompra(Compra compra) throws Exception {
        Boolean validation = false;
        String query = "call InsertarCompra (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = new ConnectionMySQL().getConnection();
        CallableStatement cstmt = con.prepareCall(query);
        try {
            cstmt.setInt(1, compra.getCantidad());
            cstmt.setDouble(2, compra.getPrecioUnitario());
            cstmt.setDouble(3, compra.getLatitud());
            cstmt.setDouble(4, compra.getLongitud());
            cstmt.setString(5, compra.getFecha());
            cstmt.setInt(6, compra.getIdCliente());
            cstmt.setInt(7, compra.getIdProducto());
            if (compra.getIdCarrito() > 0)
                cstmt.setInt(8, compra.getIdCarrito());
            else
                cstmt.setString(8, null);

            cstmt.execute();
            validation = true;
        } catch (Exception e) {
            e.printStackTrace();
            validation = false;
        }
        return validation.toString();
    }

    public List<Historial> getAllCarritos(String idCliente) throws Exception {

        List<Historial> listaHistorial = new ArrayList<>();

        Connection con = new ConnectionMySQL().getConnection();

        String sql = "SELECT * FROM vista_carrito WHERE idCliente = ' " + idCliente + " ' and comprado = 0 and onCar = 1";

        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery(sql);

        while (rs.next()) {

            listaHistorial.add(fill(rs));

        }

        return listaHistorial;

    }

    public Historial fill(ResultSet rs) throws Exception {

        Producto p = new Producto();

        p.setIdProducto(rs.getInt(9));
        p.setTitulo(rs.getString(1));
        p.setPrecio(rs.getFloat(2));
        p.setCondicion(rs.getString(3));
        p.setPlataforma(rs.getString(4));
        p.setGarantia(rs.getString(5));
        p.setDescripcion(rs.getString(6));
        p.setPublicador(rs.getString(7));
        p.setLanzamiento(rs.getString(8));
        p.setListaFotos(getPhotos(rs.getInt(9)));

        Historial h = new Historial();

        h.setIdCarrito(rs.getInt(10));
        h.setFecha(rs.getString(11));
        h.setIdCliente(rs.getInt(15));
        h.setProducto(p);
        h.setCantidad(rs.getInt(12));
        h.setComprado(rs.getInt(13));
        h.setOnCar(rs.getInt(14));

        return h;

    }

    public List<Foto> getPhotos(int idProducto) throws Exception {

        List<Foto> fotos = new ArrayList<>();

        String sql = "SELECT * FROM foto WHERE idProducto = ?";

        Connection con = new ConnectionMySQL().getConnection();

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, idProducto);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            Foto foto = new Foto(rs.getInt(1), rs.getString(2), rs.getInt(3));

            fotos.add(foto);

        }

        return fotos;
    }

    public String deleteShoppingCar(int idCarrito) {
        String verificacion;
        try {
            String query = "UPDATE carrito SET onCar = 0 WHERE idCarrito = ?";
            
            Connection con = new ConnectionMySQL().getConnection();

            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, idCarrito);

            pstmt.execute();
            
            verificacion = "ok";
        } catch (Exception e) {
            e.printStackTrace();
            verificacion = e.toString();
        }
        return verificacion.toString();
    }
}
