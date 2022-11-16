package com.example.deportistas.controller;

import com.example.deportistas.DTO.response.DeporteDTO;
import com.example.deportistas.DTO.response.DeportistaDTO;
import com.example.deportistas.entity.Deporte;
import com.example.deportistas.entity.Deportista;
import com.example.deportistas.repositorio.DeportesRepo;
import com.example.deportistas.repositorio.DeportistasRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DeportistasController {


    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        ArrayList<DeporteDTO> listaDep = new ArrayList<>();
        for(Deporte dep:DeportesRepo.lista){
            listaDep.add(new DeporteDTO(dep.getNombre()));
        }
        return new ResponseEntity<>(listaDep, HttpStatus.OK);
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name){
        Deporte nivel;
        nivel = DeportesRepo.lista.stream().filter(x -> x.getNombre().equalsIgnoreCase(name)).findFirst().orElse(new Deporte("nombre","no anduvo"));
        return new ResponseEntity<>(nivel.getNivel(), HttpStatus.OK);

    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findSportsPersons(){
        ArrayList<DeportistaDTO> listaDep = new ArrayList<>();
        for(Deportista dep: DeportistasRepo.lista){
            listaDep.add(new DeportistaDTO(dep.getNombre(),dep.getApellido(),dep.getDeporte().getNombre()));
        }
        return new ResponseEntity<>(listaDep, HttpStatus.OK);
    }


}
