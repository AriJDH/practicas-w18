package com.example.Deportista.controller;

import com.example.Deportista.DTO.DeporteDTO;
import com.example.Deportista.DTO.DeporteNivelDTO;
import com.example.Deportista.DTO.DeportistaDTO;
import com.example.Deportista.entity.Deporte;
import com.example.Deportista.entity.Persona;
import com.example.Deportista.repository.DeportesRepository;
import com.example.Deportista.repository.DeportistasRepository;
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
public class SportsController {


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getSports(){

        DeporteDTO deporteDTO = new DeporteDTO(DeportesRepository.getDeportes());

        return new ResponseEntity<List<Deporte>>(DeportesRepository.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteNivelDTO> getDeporte(@PathVariable String name){

         Deporte encontrado =  DeportesRepository.getDeportes()
                .stream()
                .filter(deportee -> name.equals(deportee.getNombre()))
                .findFirst()
                .orElse(null);
        DeporteNivelDTO deporte = new DeporteNivelDTO(encontrado.getNivel());

        return new ResponseEntity<>(deporte,HttpStatus.OK);

    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getPersonasDeportes(){
        ArrayList<Persona> deportistas = DeportistasRepository.getPersonas();
        ArrayList<DeportistaDTO> deportistaDTO = (ArrayList<DeportistaDTO>) deportistas.stream().map(persona -> new DeportistaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporteRealizado())).collect(Collectors.toList());

        return new ResponseEntity<>(deportistaDTO,HttpStatus.OK);
    }


}
