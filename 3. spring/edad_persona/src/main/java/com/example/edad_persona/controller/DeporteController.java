package com.example.edad_persona.controller;

import com.example.edad_persona.dto.DeporteDto;
import com.example.edad_persona.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    private final DeporteService deporteService;

    public DeporteController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> findSports(){

        return new ResponseEntity<>(deporteService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDto> findByName(@PathVariable String name){
        DeporteDto deporteDto = deporteService.findByName(name);
        if(deporteDto!=null){
            return new ResponseEntity<DeporteDto>(deporteDto, HttpStatus.OK);
        }else{
            return new ResponseEntity<DeporteDto>(deporteDto, HttpStatus.NOT_FOUND);
        }

    }

}
