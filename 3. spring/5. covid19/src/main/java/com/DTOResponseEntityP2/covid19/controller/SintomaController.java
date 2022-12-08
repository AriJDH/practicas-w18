package com.DTOResponseEntityP2.covid19.controller;

import com.DTOResponseEntityP2.covid19.model.Sintoma;
import com.DTOResponseEntityP2.covid19.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SintomaController {
	
	// Llamamos al SintomaService para usar sus métodos
	final
	SintomaService sintomaService;
	
	public SintomaController(SintomaService sintomaService) {this.sintomaService = sintomaService;}
	
	// Get buscar todos los sintomas
	@GetMapping("/findSymptom")
	public ResponseEntity<List<Sintoma>> buscarSintomas() {
		// Retornamos respuesta con la lista de sintomas en el body y status 200
		return new ResponseEntity<>(sintomaService.buscarTodos(), HttpStatus.OK);
	}
	
	// Get buscar sintoma por nombre
	@GetMapping("/findSymptom/{nombre}")
	public ResponseEntity<Sintoma> buscarPorNombre(@PathVariable String nombre) {
		// Buscamos el sintoma por nombre y lo devolvemos en el body con status 200
		return new ResponseEntity<>(sintomaService.buscarPorNombre(nombre), HttpStatus.OK);
	}
	
}
