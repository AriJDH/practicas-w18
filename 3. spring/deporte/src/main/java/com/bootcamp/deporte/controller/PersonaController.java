package com.bootcamp.deporte.controller;

import com.bootcamp.deporte.dto.req.PersonaReqDTO;
import com.bootcamp.deporte.dto.resp.PersonaResDTO;
import com.bootcamp.deporte.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    private PersonaService personaService=new PersonaService();

    @PostMapping("/crearPersona")
    public ResponseEntity<String> crearPersona(@RequestBody PersonaReqDTO personaReqDTO){
        personaService.crearPersona(personaReqDTO);
        return new ResponseEntity<>("Persona Creada", HttpStatus.CREATED);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaResDTO>> findSportsPersons(){
        return ResponseEntity.ok(personaService.findSportsPersons());
    }
}
