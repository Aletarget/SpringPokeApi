package com.pokeapi.pokeapi_springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pokeapi.pokeapi_springboot.Models.Pokemon;
import com.pokeapi.pokeapi_springboot.Services.PokeApiService;

@Controller
public class PokeApiController {
    private final PokeApiService pokeApiService;
    private Pokemon pokemon;
    public PokeApiController(PokeApiService pokeApiService) {
        this.pokeApiService = pokeApiService;
    }

    @PostMapping("/pokemon")
    public String getPokemon(@RequestParam("nombre") String name, Model model){
        try{
            pokemon = pokeApiService.buscarPorNombre(name);
            model.addAttribute("pokemon", pokemon);
            return "pokemon";
        }catch (Exception e) {
            return "error";
        }
    }
}
