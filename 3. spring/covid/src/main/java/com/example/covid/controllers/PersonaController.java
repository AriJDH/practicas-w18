package com.example.covid.controllers;

import com.example.covid.domain.Persona;
import com.example.covid.domain.dtos.PersonaDTO;
import com.example.covid.repositories.PersonaRepository;
import com.example.covid.repositories.RepositoryFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    PersonaRepository personaRepository = RepositoryFactory.getPersonaRepository();
    @GetMapping
    public ResponseEntity<List<PersonaDTO>> getPersonas(){
        return ResponseEntity.ok(personaRepository.findAll().stream()
                .map(p->p.toDTO()).collect(Collectors.toList()));
    }
    @GetMapping("/riesgo")
    public ResponseEntity<List<PersonaDTO>> getPersonasDeRiesgo(){
        return ResponseEntity.ok(personaRepository.findPersonasDeRiesgo().stream()
                .map(p->p.toDTO()).collect(Collectors.toList()));
    }
}
