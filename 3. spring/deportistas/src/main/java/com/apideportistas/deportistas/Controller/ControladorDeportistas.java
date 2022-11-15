package com.apideportistas.deportistas.Controller;

import com.apideportistas.deportistas.DTO.deportePersonaDTOres;
import com.apideportistas.deportistas.DTO.deportesDTOres;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorDeportistas {

    @GetMapping(path = "/findSports")
    public String todosDeportes(){
        return "h";
    }

    @GetMapping(path = "/findSports/{name}")
    ResponseEntity <String> nivelDeportePersona(@PathVariable String name){
        return new ResponseEntity<>("h"+ HttpStatus.OK);
    }

    @GetMapping(path = "/findSportsPersons")
    ResponseEntity <deportePersonaDTOres> nivelDeportePersona(){
        return new ResponseEntity<>("h"+ HttpStatus.OK);
    }

}
