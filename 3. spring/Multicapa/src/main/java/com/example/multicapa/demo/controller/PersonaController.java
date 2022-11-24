package com.example.multicapa.demo.controller;


import com.example.multicapa.demo.dto.resp.PersonaDTO;
import com.example.multicapa.demo.service.IPersonaService;
import com.example.multicapa.demo.service.PersonaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    IPersonaService personaService = new PersonaServiceImp();

    @GetMapping("")
    public ResponseEntity<List<PersonaDTO>> mostrarLista(){
        return  new ResponseEntity<>(personaService.getPErsonas(), HttpStatus.OK);
    }
}
