package com.demomulticapa.demomulticapa.controller;

import com.demomulticapa.demomulticapa.dto.PersonaDto;
import com.demomulticapa.demomulticapa.service.IPersonaService;
import com.demomulticapa.demomulticapa.service.PersonaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    IPersonaService personaService = new PersonaServiceImp();


    @GetMapping("")
    public ResponseEntity<List<PersonaDto>> mostrarLista(){
        return new ResponseEntity<>(personaService.getPersona(), HttpStatus.OK);
    }

}
