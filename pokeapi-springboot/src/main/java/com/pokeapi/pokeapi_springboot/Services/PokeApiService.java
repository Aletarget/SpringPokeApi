package com.pokeapi.pokeapi_springboot.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokeapi.pokeapi_springboot.Models.Pokemon;

@Service
public class PokeApiService {
    private final HttpClient httpClient;
    private Pokemon pokemon;
    
    public PokeApiService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public Pokemon buscarPorNombre(String name) throws IOException, InterruptedException{
         HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase()))
                .GET()
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode data = mapper.readTree(response.body());
        pokemon = new Pokemon();
        pokemon.setId(data.get("id").asInt());
        pokemon.setName(data.get("name").asText());
        pokemon.setHeight(data.get("height").asInt());
        pokemon.setWeight(data.get("weight").asInt());
        System.out.println(pokemon);
        // Procesar el JSON de la respuesta
        return pokemon;
    }


}
