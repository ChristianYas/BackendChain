package com.chaingame.store.Connection;

import java.sql.*;

public class ConnectionMySQL {
    
    public Connection getConnection() throws Exception{

        String uriCloud = "jdbc:mysql://uzgkzvrgoomqtjrd:DYeBOGm7sfS2JqSAyXfx@bbk1jb6ydvdh4iq2jlkj-mysql.services.clever-cloud.com:3306/bbk1jb6ydvdh4iq2jlkj";
        
        String uriLocal = "jdbc:mysql://localhost:3306/games";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(uriLocal, "root", "root");

        return con;

    }
    

}
