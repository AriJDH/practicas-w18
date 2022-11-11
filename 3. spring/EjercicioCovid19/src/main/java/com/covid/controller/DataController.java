package com.covid.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.covid.DTO.PersonaConSintomaDTO;
import com.covid.DTO.SintomaDTO;
import com.covid.services.ServiceDatos;

@RestController
public class DataController {
	
	@Autowired
	private ServiceDatos service;
	
	@GetMapping("/findSymptom")
	public ResponseEntity<SintomaDTO> getSintoma(){
		
		return new ResponseEntity(service.getSintoma(), HttpStatus.OK);
	}
	
	@GetMapping("/findSymptom/{name}")
	public ResponseEntity<SintomaDTO> getSintomaByName(@PathVariable String name){
		return new ResponseEntity(service.getSintomaByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/findRiskPerson")
	public ResponseEntity<PersonaConSintomaDTO> getPersonasConSintomas(){
		
		return new ResponseEntity(service.getPersonasDeRiesgo(), HttpStatus.OK);
	}

}
