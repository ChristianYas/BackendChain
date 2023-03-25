package com.chaingame.store.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chaingame.store.controller.ControllerCompras;
import com.chaingame.store.models.Carrito;
import com.chaingame.store.models.Historial;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/shopping")
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST})
public class compras {
    
    @PostMapping(value="/addShoppingCar")
    public String postMethodName(@RequestBody Carrito carrito) throws Exception{
        
        ControllerCompras cc = new ControllerCompras();

        cc.addShoppingCar(carrito);
        
        return "ok";
    }
    
    @GetMapping(value="/getShoppingCars")
    public List<Historial> getMethodName(@RequestParam String idCliente) throws Exception{
       
        List<Historial> listaCarritos = new ArrayList<>();
       
        ControllerCompras cc = new ControllerCompras();

        listaCarritos = cc.getAllCarritos(idCliente);

        return listaCarritos;
    }
    
}
