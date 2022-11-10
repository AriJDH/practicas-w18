package com.deportes.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.deportes.demo.DTO.PersonaDeportistaDTO;
import com.deportes.demo.entity.Deporte;
import com.deportes.demo.repositorio.RepoDeDatos;

@RestController
@RequestMapping("/inicio")
public class PersonaDeporteController {
	
	@Autowired
	private RepoDeDatos datos;
	
	@GetMapping("/findSport")
	public List<Deporte> getDeportes(){
		
		return datos.getDeportes();
		
	}
	
	@GetMapping("/findSport/{name}")
	public String getDeportebyName(@PathVariable String name){
		
		return datos.getDeportes().stream()
				.filter(d -> d.getNombre().equals(name))
				.map(d -> d.getNivel())
				.findFirst()
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"No se encontro deporte con nombre " + name));
		
	}
	
	@GetMapping("/findSportsPersons")
	public ResponseEntity<PersonaDeportistaDTO> getPersonasDeportistas(){
		
		return new ResponseEntity(datos.getDTO(), HttpStatus.OK);
		
	}

}
