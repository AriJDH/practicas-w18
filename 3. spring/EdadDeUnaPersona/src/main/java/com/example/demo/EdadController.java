package com.example.demo;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadController {
	
	@GetMapping("/{dia}/{mes}/{anio}")
	public String get(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
		
		LocalDate fecha = LocalDate.of(anio, mes, dia); 
		
		Period periodo = Period.between(fecha, LocalDate.now());
		
		return String.valueOf(periodo.getYears());
	}

}
