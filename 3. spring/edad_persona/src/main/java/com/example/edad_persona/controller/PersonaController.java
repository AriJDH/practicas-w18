package com.example.edad_persona.controller;

import com.example.edad_persona.dto.DeporteDto;
import com.example.edad_persona.dto.PersonaDto;
import com.example.edad_persona.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ResourceBundle;

@RestController
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping("/{dia}/{mes}/{anio}")
    public String getFecha(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio ){
        return "La feche de nacimiento es: " + dia + "/"+ mes + "/" + anio;
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDto>> findSports(){

        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);

    }

}


