package com.deportista.clase2.controller;

import com.deportista.clase2.DTO.DeporteDTORes;
import com.deportista.clase2.DTO.DeportistaDTORes;
import com.deportista.clase2.entity.Deporte;
import com.deportista.clase2.entity.Persona;
import com.deportista.clase2.repo.RepoDeportes;
import com.deportista.clase2.repo.RepoPersonas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class DeportistaController {
    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<DeporteDTORes>> findSports() {
        ArrayList<Deporte> deportesEntity = RepoDeportes.getDeportes();
        ArrayList<DeporteDTORes> deportesDTO = new ArrayList<DeporteDTORes>();

        for (Deporte e : deportesEntity) {
            deportesDTO.add(new DeporteDTORes(e.getName(), e.getNivel()));
        }
        return new ResponseEntity<>(deportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTORes> getSport(@PathVariable String name) {
        for (Deporte dep : RepoDeportes.getDeportes()) {
            if (dep.getName().equals(name)) {
                DeporteDTORes deporteDTORes = new DeporteDTORes(dep.getName(), dep.getNivel());
                return new ResponseEntity<>(deporteDTORes, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<DeportistaDTORes> getDeportistas() {
        ArrayList<Persona> personsEntity = RepoPersonas.getPersonas();
        ArrayList<DeportistaDTORes> deportistaDTORes = new ArrayList<>();
        for (Persona per : personsEntity) {
            if (per.getDeportesFrecuentes().size() > 0) {
                deportistaDTORes.add(new DeportistaDTORes(per.getName(), per.getLastName(), per.getDeportesFrecuentes().get(0).getName()));
            }
        }
        return new ResponseEntity(deportistaDTORes, HttpStatus.OK);
    }

}
