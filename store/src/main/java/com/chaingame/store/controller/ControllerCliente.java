package com.chaingame.store.controller;

import com.chaingame.store.Connection.ConnectionMySQL;
import com.chaingame.store.models.Cliente;

import java.sql.*;

public class ControllerCliente {
 
    
    public boolean insertClient(Cliente cliente) throws Exception{

        boolean validation = false;

        Connection con = new ConnectionMySQL().getConnection();

        String sql = "CALL insertClient(?,?,?,?,?,?,?,?,?,?)";

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

        validation = cstmt.execute();

        return validation;

        
    }

}
