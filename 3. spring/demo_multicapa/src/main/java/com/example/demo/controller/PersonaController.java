package com.example.demo.controller;

import com.example.demo.dto.response.PersonaDto;
import com.example.demo.service.IPersonaService;
import com.example.demo.service.PersonaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    IPersonaService personaService = new PersonaServiceImp();

    @GetMapping("")
    public ResponseEntity<List<PersonaDto>> mostrarLista(){
        return new ResponseEntity<>(personaService.getPersona(), HttpStatus.OK);
    }
}
