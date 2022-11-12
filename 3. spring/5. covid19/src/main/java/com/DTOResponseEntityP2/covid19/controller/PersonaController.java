package com.DTOResponseEntityP2.covid19.controller;

import com.DTOResponseEntityP2.covid19.model.PersonaDTO;
import com.DTOResponseEntityP2.covid19.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	// @GetMapping("/findRiskPerson")
	//public ResponseEntity<PersonaDTO> buscarPersonasDeRiesgo() {
	// }
	
}
