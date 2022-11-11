package com.example.demo.controller;

import com.example.demo.dto.response.PersonajeDTO;
import com.example.demo.service.IPersonajeService;
import com.example.demo.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    IPersonajeService personajeService = new PersonajeService();

    @GetMapping("getPersonaje/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonaje(@PathVariable String name){
        return new ResponseEntity<>(personajeService.getPersonaje(name), HttpStatus.OK);
    }
}
