package com.example.covid19.controller;

import com.example.covid19.DTO.SintomaDTO;
import com.example.covid19.entity.Sintoma;
import com.example.covid19.repository.PersonaRepo;
import com.example.covid19.repository.SintomasRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class Controller {

    SintomasRepo sintomasRepo = new SintomasRepo();
    PersonaRepo personaRepo = new PersonaRepo();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> findSintomas(){

        List<SintomaDTO> sintomasDTO = sintomasRepo.sintomas.stream()
                .map(s -> new SintomaDTO(s.getCodigo(),
                                s.getNombre(),
                                s.getNivelDeGravedad())).collect(Collectors.toList());

        return new ResponseEntity<>(sintomasDTO, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> finsSintomabyName(@PathVariable String name){

        Sintoma sintoma = sintomasRepo.sintomas.stream().filter(s -> s.getNombre().equals(name.toLowerCase())).findFirst().orElse(null);
        SintomaDTO sintomaDTO = new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad());

        return new ResponseEntity<>(sintomaDTO, HttpStatus.OK);

    }

}
