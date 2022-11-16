package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IPersonaService;
import com.example.starwars.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @GetMapping("/getChars/{busqueda}")
    public ResponseEntity<List<PersonajeDTO>> getChars(String busqueda){
        IPersonaService ps = new PersonaService();
        return new ResponseEntity<List<PersonajeDTO>>(ps.getChars(busqueda),HttpStatus.OK);
    }
}
