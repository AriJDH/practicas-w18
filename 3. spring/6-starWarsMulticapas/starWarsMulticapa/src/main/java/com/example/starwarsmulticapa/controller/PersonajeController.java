package com.example.starwarsmulticapa.controller;

import com.example.starwarsmulticapa.dto.request.PersonajeDTO;
import com.example.starwarsmulticapa.service.IPersonajeService;
import com.example.starwarsmulticapa.service.PersonajeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    private IPersonajeService personajeService = new PersonajeServiceImp();

    //consultas
    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> find(@PathVariable String name){
        return new ResponseEntity<>(personajeService.searchByName(name), HttpStatus.OK);
    }
}
