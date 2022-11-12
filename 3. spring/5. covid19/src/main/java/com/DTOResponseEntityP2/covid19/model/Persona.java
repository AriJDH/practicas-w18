package com.DTOResponseEntityP2.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
	
	// Atributos
	private Long id;
	private String nombre;
	private String apellido;
	private Integer edad;
	
}
