package com.chaingame.store.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaingame.store.controller.ControllerConsola;
import com.chaingame.store.models.Consola;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/consola")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class consola {

    @GetMapping(value="/get")
    public List<Consola> getConsolas(@RequestParam String plataform, @RequestParam String filter) throws Exception{

        ControllerConsola cc = new ControllerConsola();

        List<Consola> listaConsolas = cc.getAll(plataform, filter);

        return listaConsolas;
    }
    

    
}
