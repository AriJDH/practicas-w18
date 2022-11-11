package com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.repository;

import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.DeporteDto;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.Nivel;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.PersonaDeportistaDto;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.PersonaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Repository {
	
	// Creamos las personas y los deportes
	// Personas
	PersonaDto personaDto1 = new PersonaDto("Nombre1", "Apellido1", 30);
	PersonaDto personaDto2 = new PersonaDto("Nombre2", "Apellido2", 25);
	// Deportes
	DeporteDto deporteDto1 = new DeporteDto("Deporte1", Nivel.profesional);
	DeporteDto deporteDto2 = new DeporteDto("Deporte2", Nivel.amateur);
	// Deportistas
	PersonaDeportistaDto personaDeportistaDto1 =
					new PersonaDeportistaDto(personaDto1.getApellido() + " " + personaDto1.getNombre(),
									deporteDto1.getNombre());
	
	PersonaDeportistaDto personaDeportistaDto2 =
					new PersonaDeportistaDto(personaDto2.getApellido() + " " + personaDto2.getNombre(),
									deporteDto1.getNombre());
	
	// Creamos una base de datos de prueba
	List<PersonaDto> personaDtoList = Arrays.asList(personaDto1, personaDto2);
	List<DeporteDto> deporteDtoList = Arrays.asList(deporteDto1, deporteDto2);
	List<PersonaDeportistaDto> deportistasList = Arrays.asList(personaDeportistaDto1,personaDeportistaDto2);
	
}