package com.chaingame.store.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaingame.store.controller.ControllerVideoJuego;
import com.chaingame.store.models.VideoJuego;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/videoJuego")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class videojuego {

    @GetMapping(value="/get")
    public List<VideoJuego> getMethodName(@RequestParam String plataform, String filter) throws Exception{
        
        ControllerVideoJuego cv = new ControllerVideoJuego();

        List<VideoJuego> listVideoJuego = cv.getAll(plataform, filter);

        return listVideoJuego;
    }
    
    
}
