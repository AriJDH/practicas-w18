package com.example.demo.controller;

import com.example.demo.DTO.response.DeporteDTORes;
import com.example.demo.DTO.response.PeopleDTORes;
import com.example.demo.model.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    Model modelo;
    public Controller(){
        modelo = new Model();
    }
    //* PATH: /findSports
    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTORes>> findSports(){
        List<DeporteDTORes> request = modelo.findSports();
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    //PATH: /findSport/{name}

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTORes> findSport(@PathVariable String name){
        DeporteDTORes request = modelo.findSport(name);
        return new ResponseEntity<>(request,HttpStatus.OK);
    }

    //PATH: /findSportsPersons
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PeopleDTORes>> findSportsPersons(){
        List<PeopleDTORes> request = modelo.findSportsPersons();
        return new ResponseEntity<>(request,HttpStatus.OK);
    }
}
