package com.chaingame.store.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaingame.store.controller.ControllerCliente;
import com.chaingame.store.models.Cliente;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class cliente {
    
    @PostMapping(value="/insertar")
    public String postMethodName(@RequestBody Cliente cliente) throws Exception{
        
        ControllerCliente cc = new ControllerCliente();

        String validation = cc.insertClient(cliente);

        return validation;
    }
    
}
