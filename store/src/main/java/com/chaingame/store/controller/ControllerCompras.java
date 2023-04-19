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
        String query = "call InsertarCompra (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = new ConnectionMySQL().getConnection();
        CallableStatement cstmt = con.prepareCall(query);
        try {
            cstmt.setInt(1, compra.getIdCompra());
            cstmt.setDouble(2, compra.getCantidad());
            cstmt.setDouble(3, compra.getPrecioUnitario());
            cstmt.setDouble(4, compra.getLatitud());
            cstmt.setDouble(5, compra.getLongitud());
            cstmt.setInt(6, compra.getIdCarrito());
            cstmt.setString(7, compra.getFecha());
            cstmt.setInt(8, compra.getIdCliente());
            cstmt.setInt(9, compra.getProducto().getIdProducto());
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

        String sql = "SELECT * FROM vista_carrito WHERE idCliente = ' " + idCliente
                + " ' and comprado = 0 and onCar = 1";

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

    public List<Compra> getAllCompras(int idCliente) {
        List<Compra> listCompras = new ArrayList<>();

        String query = "select * from vista_historial where idCliente = " + idCliente;

        try {

            Connection con = new ConnectionMySQL().getConnection();
            PreparedStatement pstmt;
            pstmt = con.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery(query);

            while (rs.next()) {

                listCompras.add(fillCompra(rs));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCompras;

    }
    public Compra fillCompra(ResultSet rs) throws Exception{

        Producto p = new Producto();
        p.setIdProducto(rs.getInt("idProducto"));
        p.setTitulo(rs.getString("titulo"));
        p.setPrecio(rs.getFloat("precio"));
        p.setCondicion(rs.getString("condicion"));
        p.setPlataforma(rs.getString("plataforma"));
        p.setGarantia(rs.getString("garantia"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setPublicador(rs.getString("publicador"));
        p.setLanzamiento(rs.getString("lanzamiento"));
        p.setListaFotos(getPhotos(rs.getInt("idProducto")));

        Compra compra = new Compra();
        compra.setIdCompra(rs.getInt("idCompra"));
        compra.setCantidad(rs.getInt("cantidad"));
        compra.setPrecioUnitario(rs.getFloat("precioUnitario"));
        compra.setLatitud(rs.getFloat("latitud"));
        compra.setLongitud(rs.getFloat("longitud"));
        compra.setIdCarrito(rs.getInt("idCarrito"));
        compra.setFecha(rs.getString("fecha"));
        compra.setIdCliente(rs.getInt("idCliente"));
        compra.setProducto(p);

        return compra;

    }
    
}
