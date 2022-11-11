package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.DTO.DatosDTO;
import com.food.DTO.PlatoDTO;
import com.food.service.IServiceFood;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	IServiceFood serviceFood;
	
	@GetMapping()
	public ResponseEntity<DatosDTO> getDatosDto(@RequestBody PlatoDTO platoDto){
		
		DatosDTO datosDto= serviceFood.getDataDelPlato(platoDto);
		return new ResponseEntity<DatosDTO>(datosDto, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<DatosDTO> getDatosDto(@RequestBody List<PlatoDTO> platoDto){
		
		List<DatosDTO> datosDto= serviceFood.getDataDeListaDePlatos(platoDto);
		return new ResponseEntity(datosDto, HttpStatus.OK);
	}

}
