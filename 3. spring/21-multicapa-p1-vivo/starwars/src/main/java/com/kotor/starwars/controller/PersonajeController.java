package com.kotor.starwars.controller;

import com.kotor.starwars.dto.response.PersonajeDTORes;
import com.kotor.starwars.service.IPersonajeService;
import com.kotor.starwars.service.PersonajeServiceImp;
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
    private IPersonajeService personajeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTORes>> showList(@PathVariable String name) {
        return new ResponseEntity<>(personajeService.getPeople(name), HttpStatus.OK);
    }
}
