package com.example.demodeportistas.controller;

import com.example.demodeportistas.DTO.DeporteDTO;
import com.example.demodeportistas.DTO.PersonaDTO;
import com.example.demodeportistas.entity.Deporte;
import com.example.demodeportistas.entity.Persona;
import com.example.demodeportistas.repository.DeporteRepository;
import com.example.demodeportistas.repository.PersonaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonasController {
    DeporteRepository deporteRepo = new DeporteRepository();
    PersonaRepository personaRepo = new PersonaRepository();


    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        List<DeporteDTO> deportesDto = new ArrayList<>();

        for (Deporte deporte : deporteRepo.deportes) {
            deportesDto.add(new DeporteDTO(deporte.getNombre(), deporte.getNivel()));
        }
        return new ResponseEntity<>(deportesDto, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String name){
        Optional<Deporte> deporte = deporteRepo.deportes.stream().filter(m -> m.getNombre().equals(name.toLowerCase())).findFirst();

        if (deporte.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            DeporteDTO deporteDto = new DeporteDTO(deporte.get().getNombre(), deporte.get().getNivel());
            return new ResponseEntity<>(deporteDto, HttpStatus.OK);
        }
    }

    @GetMapping("/findSportPersons")
    public ResponseEntity<?> findSportsPersons(){
        List<PersonaDTO> personasDto = new ArrayList<>();

        for (Persona persona : personaRepo.personas) {
            personasDto.add(new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()));
        }
        return new ResponseEntity<>(personasDto, HttpStatus.OK);
    }
}
