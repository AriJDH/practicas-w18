package com.apistarwars.StarWarsPersonajes.controller;

import com.apistarwars.StarWarsPersonajes.dto.PersonajeDTO;
import com.apistarwars.StarWarsPersonajes.service.IPersonajesService;
import com.apistarwars.StarWarsPersonajes.service.PersonajesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajesController {

    IPersonajesService personajesService;

    public PersonajesController (PersonajesService personajesService){
        this.personajesService=personajesService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> mostrarPersonajes(@PathVariable String nombre){
        return new ResponseEntity<>(personajesService.retornarListaPersonajes(nombre), HttpStatus.OK);
    }
}
