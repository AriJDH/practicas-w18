package com.jcundere.ejerciciopractico04.controller;

import com.jcundere.ejerciciopractico04.DTO.response.DeporteResponse;
import com.jcundere.ejerciciopractico04.DTO.response.PersonaDeportistaResponse;
import com.jcundere.ejerciciopractico04.entity.Persona;
import com.jcundere.ejerciciopractico04.mapper.DeporteMapper;
import com.jcundere.ejerciciopractico04.mapper.PersonaDeportistaMapper;
import com.jcundere.ejerciciopractico04.repository.DeporteImp;
import com.jcundere.ejerciciopractico04.repository.PersonaImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    public DeporteImp deporteImp = new DeporteImp();
    public PersonaImp personaImp = new PersonaImp();


    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteResponse>> findSports() {

        List<DeporteResponse> response = DeporteMapper.deporteList2DeporteResponseList(deporteImp.traeTodos());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteResponse> findSport(@PathVariable String name) {

        DeporteResponse response = new DeporteResponse();
        if (deporteImp.buscar(name).isPresent()) {
            response = DeporteMapper.deporte2DeporteResponse(deporteImp.buscar(name).get());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeportistaResponse>> getAllPersonaDeportista() {

        List<PersonaDeportistaResponse> response = new ArrayList<>();

        for (Persona elemento : personaImp.traeTodos()) {

            if (elemento.getDeportesPracticados().size() > 0) {
                response.add(PersonaDeportistaMapper.persona2PersonaDeportistaResponse(elemento));
            }
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
