package com.chaingame.store.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaingame.store.controller.ControllerAccesorio;
import com.chaingame.store.models.Accesorio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/accesorio")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class accesorio {
    

    @GetMapping(value="/get")
    public List<Accesorio> getMethodName(@RequestParam String plataform, @RequestParam String filter) throws Exception{

        ControllerAccesorio ca = new ControllerAccesorio();

        List<Accesorio> listaAccesorios = ca.getAll(plataform, filter);

        return listaAccesorios;
    }
    
}
