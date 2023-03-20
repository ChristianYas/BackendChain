package com.chaingame.store.controller;

import java.sql.*;

import com.chaingame.store.Connection.ConnectionMySQL;
import com.chaingame.store.models.Cliente;

public class ControllerLoginn {

    public Cliente login(String userName, String password) throws Exception {

        Cliente cliente = new Cliente();

        boolean result = false;

        ConnectionMySQL mySQL = new ConnectionMySQL();

        Connection conn = mySQL.getConnection();

        String sql = "CALL logueo(?, ?, ?)";

        CallableStatement pstmt = conn.prepareCall(sql);

        pstmt.setString(1, userName);
        pstmt.setString(2, password);
        pstmt.registerOutParameter(3, Types.BOOLEAN);

        pstmt.execute();

        result = pstmt.getBoolean(3);

        if(result){
            cliente = getCliente(userName, password);
        }

        return cliente;
    }

    public Cliente getCliente(String userName, String password) throws Exception{

        Cliente c = new Cliente();

        Connection con = new ConnectionMySQL().getConnection();

        String sql = "SELECT * FROM Cliente WHERE nombreUsuario = ? AND contrasenia = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, userName);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){

            c.setIdCliente(rs.getInt(1));
            c.setNombre(rs.getString(2));
            c.setPrimerApellido(rs.getString(3));
            c.setSegundoApellido(rs.getString(4));
            c.setEdad(rs.getInt(5));
            c.setNombreUsuario(rs.getString(6));
            c.setContrasenia(rs.getString(7));
            c.setCalle(rs.getString(8));
            c.setColonia(rs.getString(9));
            c.setPais(rs.getString(10));
            c.setToken(rs.getString(11));
        }

        return c;
    }

}
