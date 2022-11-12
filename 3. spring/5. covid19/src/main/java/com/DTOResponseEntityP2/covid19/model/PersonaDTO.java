package com.DTOResponseEntityP2.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
	
	// Atributos
	private String nombre;
	private String apellido;
	private Integer edad;
	private String sintomaAsociado;
	
}
