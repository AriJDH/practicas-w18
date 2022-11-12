package com.arquitecturaMulticapaP1Vivo.personajesStarWars.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Setter
public class Personaje {
	
	// Representación del Objeto
	private String name;
	private int height;
	private int mass;
	private String hairColor;
	private String skinColor;
	private String eyeColor;
	private String birthYear;
	private String gender;
	private String homeworld;
	private String species;
}
