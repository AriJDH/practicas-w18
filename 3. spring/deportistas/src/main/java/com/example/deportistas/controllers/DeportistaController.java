package com.example.deportistas.controllers;

import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.entities.Deporte;
import com.example.deportistas.services.DeportistaSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistaController {
    @Autowired
    private DeportistaSerivce deportistaSerivce;

    @GetMapping("/findSports")
    public List<Deporte> getDeportes(){
        return deportistaSerivce.getDeportes();
    }
    @GetMapping("/findSport/{sport}")
    public Deporte getDeporte(@PathVariable String sport){
        return deportistaSerivce.getDeporte(sport);
    }
    @GetMapping("/findSportsPersons")
    public List<DeportistaDto> getDeportistas(){
        return deportistaSerivce.getDeportistas();
    }

    




}
