package com.example.Multicapa.controller;

import com.example.Multicapa.dto.request.PersonaDTO;
import com.example.Multicapa.entity.Persona;
import com.example.Multicapa.service.IPersonaService;
import com.example.Multicapa.service.PersonaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    private IPersonaService personaService = new PersonaServiceImp();


    @GetMapping("")
    public ResponseEntity<List<PersonaDTO>> mostrarLista(){
        return new ResponseEntity<>(personaService.getPersona(), HttpStatus.OK);

    }
}
