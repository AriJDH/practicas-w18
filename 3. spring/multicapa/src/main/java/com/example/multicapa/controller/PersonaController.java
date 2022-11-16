package com.example.multicapa.controller;

import com.example.multicapa.dto.request.PersonaDto;
import com.example.multicapa.service.IPersonaService;
import com.example.multicapa.service.PersonaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    private IPersonaService personaService = new PersonaServiceImp();

    @GetMapping("")
    public ResponseEntity<List<PersonaDto>> mostrarLista(){
        return new ResponseEntity<>(personaService.getPersonas(), HttpStatus.OK);
    }
}
