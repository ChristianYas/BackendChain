package com.chaingame.store.models;

public class DatosLogin {
 
    String userName;
    String password;

    
    public DatosLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

   

    

}
