package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.service.IPersonajeService;
import com.example.starwars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonajeController {

    IPersonajeService personajeService = new PersonajeService();

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDto>> mostrarPersonajesPorNombre(@PathVariable String name){
        return new ResponseEntity<>(personajeService.findByName(name), HttpStatus.OK);
    }

}
