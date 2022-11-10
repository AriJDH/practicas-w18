package com.deportista.deportistas.controller;

import com.deportista.deportistas.dto.DeporteDto;
import com.deportista.deportistas.dto.PersonaDto;
import com.deportista.deportistas.model.Deporte;
import com.deportista.deportistas.model.Persona;
import com.deportista.deportistas.repository.Repositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistaController {

    Repositorio repo = new Repositorio();

    @GetMapping("/findSports")
    public ResponseEntity<String> findSports(){
        return new ResponseEntity<>("Los deportes son: "+ this.repo.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name){

        List<Integer> niveles = new ArrayList<>();
        for (Deporte d: repo.getDeportes()){
            if(d.getNombre().equals(name)){
                niveles.add(d.getNivel());
            }
        }
        if(niveles.isEmpty())
            return new ResponseEntity<>("No se encontro el deporte: " +name,HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>("El nivel/es del deporte es/son: " + niveles,HttpStatus.OK);

    }


    @GetMapping("/findSportsPersons")
    public ResponseEntity<String> findSportsPersons(){
        List<PersonaDto> p= new ArrayList<>();
        PersonaDto pDto = new PersonaDto();

       for(Persona persona: repo.getPersonas()){

           pDto.setNombre(persona.getNombre());
           pDto.setApellido(persona.getApellido());
           for(Deporte dep:persona.getDeportes()){
               DeporteDto d = new DeporteDto();
               d.setNombre(dep.getNombre());
               pDto.getDeportes().add(d);
           }
           p.add(pDto);
       }

       return new ResponseEntity<>(p.toString(),HttpStatus.OK);
    }

}
