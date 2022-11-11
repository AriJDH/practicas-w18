package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IPersonajeService;
import com.example.starwars.service.PersonaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    IPersonajeService personajeService = new PersonaServiceImp();

    @GetMapping("/starwars/{query}")
    public ResponseEntity<List<PersonajeDTO>> findPersonajes(@PathVariable String query){
        return new ResponseEntity<>(personajeService.getPersonajes(query) , HttpStatus.OK);
    }
}
