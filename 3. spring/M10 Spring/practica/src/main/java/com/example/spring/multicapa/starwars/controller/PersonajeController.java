package com.example.spring.multicapa.starwars.controller;

import com.example.spring.multicapa.starwars.dto.PersonajeDTOResponse;
import com.example.spring.multicapa.starwars.service.IPersonajeService;
import com.example.spring.multicapa.starwars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    IPersonajeService iPersonajeService = new PersonajeService();

    @GetMapping("/starwars/personajes")
    public ResponseEntity<List<PersonajeDTOResponse>> getAll(){
        return new ResponseEntity<>(iPersonajeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/starwars/personajes/{name}")
    public ResponseEntity<List<PersonajeDTOResponse>> getByname(@PathVariable String name){
        return new ResponseEntity<>(iPersonajeService.findByName(name), HttpStatus.OK);
    }
}
