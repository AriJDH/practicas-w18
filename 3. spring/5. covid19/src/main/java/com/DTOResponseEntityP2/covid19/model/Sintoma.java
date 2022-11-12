package com.DTOResponseEntityP2.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
	
	// Atributos
	private Long codigo;
	private String nombre;
	private NivelDeGravedad nivelDeGravedad;
}
