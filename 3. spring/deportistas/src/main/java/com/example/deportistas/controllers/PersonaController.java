package com.example.deportistas.controllers;

import com.example.deportistas.DTOs.DeportistaDTO;
import com.example.deportistas.DTOs.PersonaDTO;
import com.example.deportistas.repositories.PersonaRepository;
import com.example.deportistas.repositories.RepositoryFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonaController {
    private PersonaRepository personaRepository = RepositoryFactory.getPersonaRepository();

    @GetMapping("/personas")
    public ResponseEntity<List<PersonaDTO>> getPersonas(){
        return ResponseEntity.ok(
          personaRepository.findAll().stream().map(p->new PersonaDTO(p)).collect(Collectors.toList())
        );
    }

    @GetMapping("/deportistas")
    public ResponseEntity<List<DeportistaDTO>> getDeportistas(){
        return ResponseEntity.ok(
                personaRepository.findAll().stream().map(p->new DeportistaDTO(p)).collect(Collectors.toList())
        );
    }
}
