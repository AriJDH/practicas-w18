package com.example.starwars.controller;

import com.example.starwars.dto.response.PersonajeResponseDto;
import com.example.starwars.service.IPersonajeService;
import com.example.starwars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class PersonajeController {
    IPersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/buscarPersonaje/{name}")
    public ResponseEntity<List<PersonajeResponseDto>> buscarPersonaje(@PathVariable String name){
        return new ResponseEntity<>(personajeService.mostrarPersonajesPorNombre(name), HttpStatus.OK);
    }


}
