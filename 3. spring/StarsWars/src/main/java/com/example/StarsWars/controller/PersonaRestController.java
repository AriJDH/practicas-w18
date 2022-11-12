package com.example.StarsWars.controller;

import com.example.StarsWars.dto.response.PersonajeDtoRes;
import com.example.StarsWars.entity.Personaje;
import com.example.StarsWars.service.IPersonajeService;
import com.example.StarsWars.service.PersonajeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaRestController {

    //Creo una instnacia del servicio para poder acceder a los metodos del mismo.
    IPersonajeService personajeService = new PersonajeServiceImp();

    @GetMapping("/personaje/{palabra}")
    public ResponseEntity<List<PersonajeDtoRes>> getPersonaje(@PathVariable String palabra){
        return new ResponseEntity<List<PersonajeDtoRes>>(personajeService.getPersonajesServ(palabra), HttpStatus.OK);
    }
}
