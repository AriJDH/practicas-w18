package com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.controller;

import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.DeporteDto;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.PersonaDeportistaDto;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.repository.Repository;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
	
	Service service = new Service();
	
	@GetMapping("/findSports")
	public ResponseEntity<List<DeporteDto>> buscarTodos() {
		List<DeporteDto> deportes = service.buscarTodos();
		return new ResponseEntity<>(deportes, HttpStatus.OK);
	}
	
	@GetMapping("/findSport/{name}")
	public ResponseEntity<DeporteDto> buscarDeportePorNombre(@PathVariable String name) {
		DeporteDto deporteEncontrado = service.buscarDeporte();
		return new ResponseEntity(deporteEncontrado.getNivel(), HttpStatus.OK);
	}
	
	@GetMapping("/findSportsPersons")
	public ResponseEntity<PersonaDeportistaDto> buscarDeportistas() {
		List<PersonaDeportistaDto> deportistas = service.buscarTodosDeportistas();
		return new ResponseEntity(deportistas, HttpStatus.OK);
	}
	
}
