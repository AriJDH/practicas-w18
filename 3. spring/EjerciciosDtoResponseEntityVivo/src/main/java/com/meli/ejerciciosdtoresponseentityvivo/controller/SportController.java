package com.meli.ejerciciosdtoresponseentityvivo.controller;

import com.meli.ejerciciosdtoresponseentityvivo.dto.PersonDTO;
import com.meli.ejerciciosdtoresponseentityvivo.model.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SportController {

    private List<Sport> sportList = new ArrayList<>();
    private List<PersonDTO> personList = new ArrayList<>();

    private SportController() {
        //carga de prueba
        this.sportList.add(new Sport("futbol", "amateur"));
        this.sportList.add(new Sport("futbol", "profesional"));
        this.sportList.add(new Sport("baloncesto", "profesional"));
        this.personList.add(new PersonDTO("juan","agudelo","futbol"));
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getAllSports() {
        return new ResponseEntity<>(sportList, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<List<Sport>> getAllSports(@PathVariable String name) {
        return new ResponseEntity<>(sportList.stream().filter(s -> s.getName().equals(name)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> getAllSportsPersons() {
        return new ResponseEntity<>(personList,HttpStatus.OK);
    }
}
