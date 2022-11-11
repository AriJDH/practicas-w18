package com.covid.covid.controller;

import com.covid.covid.dto.PersonaDto;
import com.covid.covid.model.Persona;
import com.covid.covid.model.Sintoma;
import com.covid.covid.repository.Repositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CovidController {

    Repositorio repo = new Repositorio();

    @GetMapping("/findSymptom")
    public ResponseEntity<String> findSymptom(){
        return new ResponseEntity<>("Los sintomas del vorus son: " + repo.getSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptom(@PathVariable String name){
        List<Integer> nivles = new ArrayList<>();
        for(Sintoma s: repo.getSintomas()){
            if(s.getNombre().equals(name))
                nivles.add(s.getNivelGravedad());
        }
        if(!nivles.isEmpty())
            return new ResponseEntity<>("El nivel de gravedad es: "+nivles,HttpStatus.OK);
        else
            return new ResponseEntity<>("No se encontrò el sintoma: " +name, HttpStatus.NOT_FOUND);

    }

    @GetMapping(" /findRiskPerson")
    public ResponseEntity<String> findRiskPerson(){
        List<PersonaDto> pDto = new ArrayList<>();
        for (Persona p: repo.getPersonas()) {
            if (p.getEdad() > 60) {
                PersonaDto pR = new PersonaDto();
                pR.setNombre(p.getNombre());
                pR.setApellido(p.getApellido());
                pDto.add(pR);
            }
        }
        if(pDto.isEmpty())
            return new ResponseEntity<>("No hay persopnas de riesgo",HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>("LAs personas con riegos son: "+ pDto,HttpStatus.OK );
        }
}

