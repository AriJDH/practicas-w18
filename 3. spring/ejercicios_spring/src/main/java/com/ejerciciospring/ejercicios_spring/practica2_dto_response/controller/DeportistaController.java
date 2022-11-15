package com.ejerciciospring.ejercicios_spring.practica2_dto_response.controller;

import com.ejerciciospring.ejercicios_spring.practica2_dto_response.dtos.DeporteDTO;
import com.ejerciciospring.ejercicios_spring.practica2_dto_response.dtos.DeporteInDTO;
import com.ejerciciospring.ejercicios_spring.practica2_dto_response.dtos.PersonaDeportistaDTO;
import com.ejerciciospring.ejercicios_spring.practica2_dto_response.dtos.PersonaInDTO;
import com.ejerciciospring.ejercicios_spring.practica2_dto_response.model.*;
import com.ejerciciospring.ejercicios_spring.practica2_dto_response.repository.DeporteRepository;
import com.ejerciciospring.ejercicios_spring.practica2_dto_response.repository.PersonaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistaController {

    private final DeporteRepository deporteRepository = new DeporteRepository();

    private final PersonaRepository personaRepository = new PersonaRepository();

    @PostMapping("/crearDeporte")
    public ResponseEntity<String> crearDeporte(@RequestBody DeporteInDTO deporteInDTO) {
        this.deporteRepository.crear(new Deporte(deporteInDTO.getNombre(), deporteInDTO.getNivel()));

        return new ResponseEntity<>("se creo exitosamente", HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> consultarDeportes() {

        List<Deporte> deportes = this.deporteRepository.consultar();

        List<DeporteDTO> deporteDTOs = new ArrayList<>();

        for (Deporte deporte : deportes) {
            deporteDTOs.add(new DeporteDTO(deporte.getNombre(), deporte.getNivel(), null));
        }

        return new ResponseEntity<>(deporteDTOs, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> consultarDeportePorNombre(@PathVariable String name) {

        Deporte deporte = deporteRepository.consultarPorNombre(name);

        DeporteDTO deporteDTO;

        if (deporte == null) {
            deporteDTO = new DeporteDTO(null, null, "No existe el deporte");
            return new ResponseEntity<>(deporteDTO, HttpStatus.NOT_FOUND);
        } else {
            deporteDTO = new DeporteDTO(deporte.getNombre(), deporte.getNivel(), null);
            return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
        }
    }

    @PostMapping("/crearPersona")
    public ResponseEntity<String> crearPersona(@RequestBody PersonaInDTO personaInDTO) {

        Deporte deporte = this.deporteRepository.consultarPorNombre(personaInDTO.getNombreDeporte());

        if (deporte == null) {
            return new ResponseEntity<>("No existe el deporte", HttpStatus.OK);
        }

        this.personaRepository.crear(
                new Persona(personaInDTO.getNombre(),
                personaInDTO.getApellido(),
                personaInDTO.getEdad(), deporte));

        return new ResponseEntity<>("se creo exitosamente", HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaDTO>> consultarPersonasDeportistas() {

        List<Persona> personas = this.personaRepository.consultar();

        List<PersonaDeportistaDTO> personaDeportistaDTOs = new ArrayList<>();

        for (Persona persona : personas) {

            if (persona.getDeporte() != null) {
                PersonaDeportistaDTO personaDeportistaDTO = new PersonaDeportistaDTO(persona.getNombre(),
                        persona.getApellido(), persona.getDeporte().getNivel());
                personaDeportistaDTOs.add(personaDeportistaDTO);
            }
        }

        return new ResponseEntity<>(personaDeportistaDTOs, HttpStatus.OK);
    }
}
