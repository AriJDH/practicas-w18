package com.darke.covid19.controller;

import com.darke.covid19.dto.request.PersonaRequestDto;
import com.darke.covid19.dto.response.PersonaResponseDto;
import com.darke.covid19.service.IPersonaService;
import com.darke.covid19.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class PersonaController {
    //Dependency Injections
    IPersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/createPerson")
    public ResponseEntity<PersonaRequestDto> crearPersona(@RequestBody PersonaRequestDto personaRequestDto){
        personaService.crearPersona(personaRequestDto);
        return new ResponseEntity<>(personaRequestDto, HttpStatus.CREATED);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaResponseDto>> findRiskPerson(){
        return new ResponseEntity<>(personaService.buscarPersonaRiesgo(),HttpStatus.OK);
    }

}
