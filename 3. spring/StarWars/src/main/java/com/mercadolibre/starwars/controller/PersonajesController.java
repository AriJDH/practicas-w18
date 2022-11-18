package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.service.IPersonajesService;
import com.mercadolibre.starwars.service.PersonajesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajesController {

    IPersonajesService personajesService;

    public PersonajesController(PersonajesService personajesService) {
        this.personajesService = personajesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        return new ResponseEntity(personajesService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PersonajeDTO>> getByName(@PathVariable String name){
        return new ResponseEntity(personajesService.getByName(name), HttpStatus.FOUND);
    }

}
