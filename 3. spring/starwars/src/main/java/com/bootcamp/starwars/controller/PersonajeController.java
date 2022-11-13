package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.PersojeDto;
import com.bootcamp.starwars.service.IPersonajeService;
import com.bootcamp.starwars.service.PersonajeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    private IPersonajeService personajeService=new PersonajeService();

    @GetMapping("/findByName")
    public ResponseEntity<List<PersojeDto>> findByName(@RequestParam String name){
        return ResponseEntity.ok(personajeService.findByName(name));
    }
}
