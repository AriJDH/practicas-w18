package com.spring.multicapa.controller;

import com.spring.multicapa.dto.PersonaDto;
import com.spring.multicapa.service.IPersonaService;
import com.spring.multicapa.service.PersonaServiceImp;
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
        return new ResponseEntity<>(personaService.getPersonas(), HttpStatus.OK);
    }
}
