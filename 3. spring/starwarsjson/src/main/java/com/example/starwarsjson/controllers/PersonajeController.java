package com.example.starwarsjson.controllers;

import com.example.starwarsjson.DTOs.PersonajeDTO;
import com.example.starwarsjson.entities.Personaje;
import com.example.starwarsjson.repositories.PersonajeRepository;
import com.example.starwarsjson.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {
    @Autowired private PersonajeService personajeService;
    @GetMapping("/{nameSubString}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajeByName(@PathVariable String nameSubString){
        return ResponseEntity.ok(personajeService.findAllPersonajeDTOByName(nameSubString));
    }
    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(){
        return ResponseEntity.ok(personajeService.findAllPersonajeDTO());
    }
}
