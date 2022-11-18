package com.multiacapa.starswars.controller;

import com.multiacapa.starswars.dto.PersonajeDTOres;
import com.multiacapa.starswars.service.IPersonajesService;
import com.multiacapa.starswars.service.PersonajesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajesController {

    IPersonajesService personajesService;

    public PersonajesController(PersonajesService personajesService) {
        this.personajesService = personajesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeDTOres>> getAll() {
        return new ResponseEntity(personajesService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTOres>> getByName(@PathVariable String name) {
        return new ResponseEntity(personajesService.getByName(name), HttpStatus.FOUND);
    }

}
