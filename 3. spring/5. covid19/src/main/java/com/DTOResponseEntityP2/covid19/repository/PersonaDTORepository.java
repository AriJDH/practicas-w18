package com.DTOResponseEntityP2.covid19.repository;

import com.DTOResponseEntityP2.covid19.model.PersonaDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaDTORepository {
	// TODO terminar
	// Test
	PersonaDTO personaDTO1 = new PersonaDTO("Nombre1", "Apellido1", 35, "Sintoma1");
	// Nuestra base de datos Peronas con sintoma (Tabla intermedia)
	List<PersonaDTO> personasDTO = new ArrayList<>();
}
