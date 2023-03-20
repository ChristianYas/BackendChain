package com.chaingame.store.Connection;

import java.sql.*;

public class ConnectionMySQL {
    
    public Connection getConnection() throws Exception{

        
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "root");

        return con;

    }
    

}
