package com.arquitecturaMulticapaP1Vivo.personajesStarWars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
	private double mass;
	@JsonProperty("hair_color")
	private String hairColor;
	@JsonProperty("skin_color")
	private String skinColor;
	@JsonProperty("eye_color")
	private String eyeColor;
	@JsonProperty("birth_year")
	private String birthYear;
	private String gender;
	private String homeworld;
	private String species;
}
