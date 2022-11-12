package com.arquitecturaMulticapaP1Vivo.personajesStarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonajeDTO {
	
	// Objeto plano / Atributos
	private String name;
	private int height;
	private int mass;
	private String gender;
	private String homeworld;
	private String species;
}
