package com.arquitecturaMulticapaP1Vivo.personajesStarWars.controller;

import com.arquitecturaMulticapaP1Vivo.personajesStarWars.dto.PersonajeDTO;
import com.arquitecturaMulticapaP1Vivo.personajesStarWars.service.PersonajeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
	final
	PersonajeServiceImp personajeService;
	
	public PersonajeController(PersonajeServiceImp personajeService) {
		this.personajeService = personajeService;
	}
	
	@GetMapping("/starwars/{query}")
	public ResponseEntity<List<PersonajeDTO>> findPersonajes(@PathVariable String query) {
		return new ResponseEntity<>(personajeService.getPersonajes(query), HttpStatus.OK);
	}
}