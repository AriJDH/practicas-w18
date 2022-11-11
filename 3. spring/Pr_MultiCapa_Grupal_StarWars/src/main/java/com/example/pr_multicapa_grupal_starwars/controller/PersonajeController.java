package com.example.pr_multicapa_grupal_starwars.controller;

import com.example.pr_multicapa_grupal_starwars.dto.PersonajeDto;
import com.example.pr_multicapa_grupal_starwars.repository.IPersonajeRepository;
import com.example.pr_multicapa_grupal_starwars.repository.PersonajeRepositoryImp;
import com.example.pr_multicapa_grupal_starwars.service.IPersonajeService;
import com.example.pr_multicapa_grupal_starwars.service.PersonajeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PersonajeController {

    private IPersonajeService personajesService = new PersonajeServiceImp();

    @GetMapping("")
    public ResponseEntity<List<PersonajeDto>> findAll(){
        return new ResponseEntity<>(personajesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDto>> find(@PathVariable String name){
        return new ResponseEntity<>(personajesService.findByName(name), HttpStatus.OK);
    }

}
