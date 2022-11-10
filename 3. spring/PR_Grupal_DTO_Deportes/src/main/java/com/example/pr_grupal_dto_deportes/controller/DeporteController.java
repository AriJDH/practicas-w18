package com.example.pr_grupal_dto_deportes.controller;

import com.example.pr_grupal_dto_deportes.DTO.DeporteDTORes;
import com.example.pr_grupal_dto_deportes.DTO.PersonaDTORes;
import com.example.pr_grupal_dto_deportes.entity.Deporte;
import com.example.pr_grupal_dto_deportes.entity.Persona;
import com.example.pr_grupal_dto_deportes.repos.RepoDeportes;
import com.example.pr_grupal_dto_deportes.repos.RepoPersonas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {

    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<DeporteDTORes>> findSports(){
        ArrayList<Deporte> deportesEntity = RepoDeportes.getDeportes();
        ArrayList<DeporteDTORes> deportesDTO = new ArrayList<DeporteDTORes>();

        for (Deporte e:deportesEntity) {
            deportesDTO.add(new DeporteDTORes(e.getName(), e.getNivel()));
        }

        return new ResponseEntity<>(deportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTORes> findSport(@PathVariable String name){
        Deporte entity = RepoDeportes.findDeporte(name);
        return entity != null?
                new ResponseEntity<>(new DeporteDTORes(entity.getName(), entity.getNivel()), HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTORes>> findSportsPersons(){
        List<Persona> personasEntity = RepoPersonas.findSportsPersons();
        List<PersonaDTORes> personasDTO = new ArrayList<PersonaDTORes>();

        for(Persona pe: personasEntity){
            ArrayList<DeporteDTORes> deportesDTO = new ArrayList<DeporteDTORes>();
            for(Deporte de : pe.getDeportesFrecuentes()){
                deportesDTO.add(new DeporteDTORes(de.getName(), de.getNivel()));
            }
            personasDTO.add(new PersonaDTORes(pe.getName(), pe.getLastName(), deportesDTO));
        }

        return new ResponseEntity<List<PersonaDTORes>>(personasDTO, HttpStatus.OK);
    }
}
