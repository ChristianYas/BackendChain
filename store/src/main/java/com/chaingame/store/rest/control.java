package com.chaingame.store.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaingame.store.controller.ControllerControl;
import com.chaingame.store.models.Control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/control")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class control {
    

    @GetMapping(value="/get")
    public List<Control> getControles(@RequestParam String plataform, @RequestParam String filter) throws Exception{
        
        ControllerControl cc = new ControllerControl();

        List<Control> listaControles = cc.getAll(plataform, filter);
        
        return listaControles;
    }
    
}
