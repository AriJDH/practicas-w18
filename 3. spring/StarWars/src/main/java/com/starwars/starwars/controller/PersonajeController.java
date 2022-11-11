package com.starwars.starwars.controller;

import com.starwars.starwars.dto.PersonajeDto;
import com.starwars.starwars.service.IpersonajeService;
import com.starwars.starwars.service.PersonajeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    IpersonajeService personajeService = new PersonajeServiceImp();

    @GetMapping("/{name}")
    public ResponseEntity<PersonajeDto> findByName(@PathVariable String name) {
        return new ResponseEntity<>(personajeService.findByName(name), HttpStatus.OK);
    }

}
