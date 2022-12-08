package com.DTOResponseEntityP2.covid19.repository;

import com.DTOResponseEntityP2.covid19.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImp implements IRepository<Persona> {
	
	// Tests
	Persona persona1 = new Persona(1L, "Nombre1", "Apellido1", 30, true);
	Persona persona2 = new Persona(2L, "Nombre2", "Apellido2", 65, true);
	Persona persona3 = new Persona(3L, "Nombre3", "Apellido3", 45, false);
	Persona persona4 = new Persona(4L, "Nombre4", "Apellido4", 70, false);
	
	// Nuestras <<Bases de datos>> para personas
	List<Persona> personas = new ArrayList<Persona>() {{
		add(persona1);
		add(persona2);
		add(persona3);
		add(persona4);
	}};
	
	// Buscar
	public List<Persona> buscarTodos() {
		// Retornamos la lista
		return personas;
	}
	
	public Persona buscarPorNombre(String nombre) {
		// Buscamos en la lista y filtramos por nombre
		return (Persona) personas
						.stream()
						.filter(persona -> persona.getNombre().equals(nombre));
	}
}
