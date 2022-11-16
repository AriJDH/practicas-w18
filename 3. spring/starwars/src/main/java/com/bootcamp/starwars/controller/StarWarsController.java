package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.response.StarWarsDtoResponse;
import com.bootcamp.starwars.service.IStarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    IStarWarsService starWarsService;
    @GetMapping("/buscaPersonaje/{name}")
    public ResponseEntity<List<StarWarsDtoResponse>> buscarPersonaje(@PathVariable String name){
        return new ResponseEntity<>(starWarsService.mostrarPersonajePorNombre(name), HttpStatus.OK);
    }
}
