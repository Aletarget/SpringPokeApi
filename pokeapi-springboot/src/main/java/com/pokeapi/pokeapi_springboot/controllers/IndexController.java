package com.pokeapi.pokeapi_springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.pokeapi.pokeapi_springboot.models.Pokemon;

@Controller
@RequestMapping("/app") 
public class IndexController {

    @GetMapping({"/", "/home"})
    public String index() {
        return "index";
    }

    @PostMapping("/pokemon")
    public String buscarPokemon(@RequestParam String nombre, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombre;
        
        try {
            Pokemon pokemon = restTemplate.getForObject(url, Pokemon.class);
            model.addAttribute("pokemon", pokemon);
        } catch (Exception e) {
            model.addAttribute("error", "No se encontró el Pokémon: " + nombre);
        }

        return "resultado"; 
    }
}
