package com.example.covid.controller;

import com.example.covid.dto.PersonDTORes;
import com.example.covid.service.IPersonService;
import com.example.covid.service.PersonaServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    private final IPersonService personService;

    public PersonaController(PersonaServiceImp personaServiceImp) {
        this.personService = personaServiceImp;
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDTORes>> findRiskPerson(){
        return new ResponseEntity<>(personService.findRiskPerson(), HttpStatus.OK);
    }


}
