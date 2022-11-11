package com.example.starwarsapi.controller;

import com.example.starwarsapi.dto.request.PersonajeDto;
import com.example.starwarsapi.service.IPersonajeService;
import com.example.starwarsapi.service.PersonajeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
  private IPersonajeService personajeService = new PersonajeServiceImp();

  @GetMapping("")
  public ResponseEntity<List<PersonajeDto>> mostrarPersonajes(){
      System.out.println("Personajes");
      return new ResponseEntity<>(personajeService.findAll(), HttpStatus.OK);
  }
}
