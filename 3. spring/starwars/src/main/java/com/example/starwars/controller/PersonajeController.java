package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IServicePersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    private IServicePersonaje iServicePersonaje ;

    @GetMapping("/consultarPersonajePorNombre/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> consultarPersonajePorNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(iServicePersonaje.consultarPersonajesPorNombre(nombre), HttpStatus.OK);
    }
}
