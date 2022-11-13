package com.example.starwars.controller;


import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IPersonajeService;
import com.example.starwars.service.PersonajeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    IPersonajeService personajesService;

    public PersonajeController(PersonajeServiceImpl personajesService){
        this.personajesService= personajesService;
    }
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<PersonajeDTO>> getByName(@PathVariable String name){

        return new ResponseEntity<>(personajesService.getPersonajesByName(name), HttpStatus.FOUND);

    }





}
