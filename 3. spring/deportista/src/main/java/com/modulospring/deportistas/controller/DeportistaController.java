package com.modulospring.deportistas.controller;

import com.modulospring.deportistas.dto.response.DeporteDtoResponse;
import com.modulospring.deportistas.dto.response.PersonaDtoResponse;
import com.modulospring.deportistas.service.DeportistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistaController {
    DeportistaService deportistaService = new DeportistaService();
@GetMapping("/findSports")
    public ResponseEntity<List<DeporteDtoResponse>> findSports(){
        return new ResponseEntity<>(deportistaService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<List<DeporteDtoResponse>> findSportByName(@PathVariable String name){
    return new ResponseEntity<>(deportistaService.findSportByName(name), HttpStatus.OK);
    }
@GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDtoResponse>> findSportsPersons (){
    return  new ResponseEntity<>(deportistaService.findSportsPersons(), HttpStatus.OK);
    }
}
