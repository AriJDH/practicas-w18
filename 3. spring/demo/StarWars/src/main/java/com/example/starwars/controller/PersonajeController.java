package com.example.starwars.controller;

import com.example.starwars.dto.response.PersonajeDTO;
import com.example.starwars.service.IPersonajeService;
import com.example.starwars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    private IPersonajeService personajeService = new PersonajeService();


    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> getPersonaje(String nombre) {
        return new ResponseEntity<List<PersonajeDTO>>(personajeService.getPersonajeByName(nombre), HttpStatus.OK);
    }



}
