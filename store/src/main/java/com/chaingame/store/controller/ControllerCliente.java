package com.chaingame.store.controller;

import com.chaingame.store.Connection.ConnectionMySQL;
import com.chaingame.store.models.Cliente;

import java.sql.*;

public class ControllerCliente {

    public String insertClient(Cliente cliente) {

        Boolean validation = false;

        try {
            Connection con = new ConnectionMySQL().getConnection();

            String sql = "CALL insertClient(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            CallableStatement cstmt = con.prepareCall(sql);

            cstmt.setString(1, cliente.getNombre());
            cstmt.setString(2, cliente.getPrimerApellido());
            cstmt.setString(3, cliente.getSegundoApellido());
            cstmt.setInt(4, cliente.getEdad());
            cstmt.setString(5, cliente.getNombreUsuario());
            cstmt.setString(6, cliente.getContrasenia());
            cstmt.setString(7, cliente.getCalle());
            cstmt.setString(8, cliente.getColonia());
            cstmt.setString(9, cliente.getPais());
            cstmt.setString(10, "token");
            cstmt.setString(11, cliente.getTelefonoMovil());
            cstmt.setString(12, cliente.getTelefonoCasa());
            cstmt.setString(13, cliente.getEmail());

            cstmt.execute();
            validation = true;
        } catch (Exception e) {
            e.printStackTrace();
            validation = false;
        }
        return validation.toString();
    }

    public String updateCliente(Cliente cliente) {
        Boolean verification = false;
        String query = "UPDATE cliente SET nombre = ?, primerapellido = ?, segundoapellido = ?, edad = ?, nombreUsuario = ?, contrasenia = ?, calle = ?, colonia = ?, pais = ?, telefonoMovil = ?, telefonoCasa = ?, email = ? WHERE idCliente = ?";
        try {
            Connection con = new ConnectionMySQL().getConnection();

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getPrimerApellido());
            pstmt.setString(3, cliente.getSegundoApellido());
            pstmt.setInt(4, cliente.getEdad());
            pstmt.setString(5, cliente.getNombreUsuario());

            pstmt.setString(6, cliente.getContrasenia());
            pstmt.setString(7, cliente.getCalle());
            pstmt.setString(8, cliente.getColonia());
            pstmt.setString(9, cliente.getPais());
            pstmt.setString(10, cliente.getTelefonoMovil());

            pstmt.setString(11, cliente.getTelefonoCasa());
            pstmt.setString(12, cliente.getEmail());
            pstmt.setInt(13, cliente.getIdCliente());

            pstmt.executeUpdate();
            verification = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verification.toString();

    }

}
