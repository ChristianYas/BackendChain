package com.chaingame.store.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaingame.store.controller.ControllerLoginn;
import com.chaingame.store.models.Cliente;
import com.chaingame.store.models.DatosLogin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class login {
    
    @PostMapping(value="/user")
    public Cliente postMethodName(@RequestBody DatosLogin data) throws Exception {   

        Cliente cliente;

        ControllerLoginn cl = new ControllerLoginn();

        cliente = cl.login(data.getUserName(), data.getPassword());

        return cliente;
    }
}
