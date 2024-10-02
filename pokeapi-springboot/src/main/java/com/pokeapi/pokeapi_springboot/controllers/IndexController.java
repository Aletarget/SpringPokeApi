//El package controllers debe obligatoriamente estar dentro del package del package del proyecto
package com.pokeapi.pokeapi_springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/app") //Ruta base de primer nivel
public class IndexController {
    //Manejo de peticiones del usuario 
    @GetMapping({"/","/home"}) //Uso de requestMapping de forma explicita, tambien se puede usar getMapping
        public String index(){
            return "index";
        }
}
