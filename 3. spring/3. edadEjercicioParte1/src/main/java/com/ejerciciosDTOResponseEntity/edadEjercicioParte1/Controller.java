package com.ejerciciosDTOResponseEntity.edadEjercicioParte1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class Controller {
	@GetMapping("/{dia}/{mes}/{fecha}")
	public String devolverEdad(@PathVariable Integer fecha){
		LocalDate fechaActual = LocalDate.now();
		int anioActual = fechaActual.getYear();
		String valorADevolver = String.valueOf(anioActual - fecha);
		return valorADevolver;
	}
}
