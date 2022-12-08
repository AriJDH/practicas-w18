package com.DTOResponseEntityP2.covid19.controller;

import com.DTOResponseEntityP2.covid19.model.PersonaDTO;
import com.DTOResponseEntityP2.covid19.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonaController {
	
	final
	PersonaService personaService;
	
	public PersonaController(PersonaService personaService) {this.personaService = personaService;}
	
	@GetMapping("/findRiskPerson")
	public ResponseEntity<?> buscarPersonasDeRiesgo() {
		List<PersonaDTO> personaDTOList = personaService.buscarPersonasRiesgo();
		return ResponseEntity.ok().body(personaDTOList);
	}
	
}
