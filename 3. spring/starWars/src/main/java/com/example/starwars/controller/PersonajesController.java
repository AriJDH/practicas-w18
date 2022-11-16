package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IPersonajeService;
import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajesController {
    @Autowired
    IPersonajeService service;

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes() {

        return ResponseEntity.ok(service.getPersonajes());
    }

    @GetMapping("/personajes/{nombre}")
    public  ResponseEntity<List<PersonajeDTO>> getPersonajeByName(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok(service.getPersonajeByName(nombre));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
