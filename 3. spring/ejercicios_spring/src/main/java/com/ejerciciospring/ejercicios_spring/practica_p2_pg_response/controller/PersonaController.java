package com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.controller;

import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.dto.PersonaEnfermaOutDTO;
import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.model.Persona;
import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.repository.PersonaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaController {

    private PersonaRepository personaRepository;

    public PersonaController() {
        this.personaRepository = new PersonaRepository();
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaEnfermaOutDTO>> consultarPersonasEnfermas() {

        List<PersonaEnfermaOutDTO> personaEnfermaOutDTOS = new ArrayList<>();

        List<Persona> personas = this.personaRepository.consultarEntidades();

        for (Persona persona : personas) {

            if (persona.getEdad() > 60
                    && (persona.getSintomas() != null
                            && !persona.getSintomas().isEmpty())) {
                personaEnfermaOutDTOS.add(new PersonaEnfermaOutDTO(persona.getNombre(), persona.getApellido()));
            }
        }

        return new ResponseEntity<>(personaEnfermaOutDTOS, HttpStatus.OK);
    }
}
