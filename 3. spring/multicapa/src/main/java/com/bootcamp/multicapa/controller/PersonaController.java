package com.bootcamp.multicapa.controller;


import com.bootcamp.multicapa.dto.PersonaDto;
import com.bootcamp.multicapa.service.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class  PersonaController {
    @Autowired
    PersonaServiceImp personaServiceImp;
    @GetMapping("/finAll")
    public ResponseEntity<List<PersonaDto>> finAll(){
        return new ResponseEntity<>(personaServiceImp.finAll(), HttpStatus.OK);
    }
}
