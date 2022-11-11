package com.covid.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.covid.entity.Persona;
import com.covid.entity.Sintoma;

@Repository
public class RepoDatos {
	
	List<Persona> personas = new ArrayList<>();
	List<Sintoma> sintomas = new ArrayList<>();
	
	public List<Persona> getPersonas(){
		personas.add(new Persona(1, "Pepe", "Perez", 65));
		personas.get(0).getSintomas().add(getSintomas().get(0));
		personas.add(new Persona(2, "Juan", "Nicolini", 30));
		personas.add(new Persona(3, "Goku", "Kakaroto", 77));
		personas.get(2).getSintomas().add(getSintomas().get(2));
		personas.add(new Persona(4, "Vegeta", "Orgullo", 23));
		
		return personas;
	}
	
	public List<Sintoma> getSintomas(){
		sintomas.add(new Sintoma(200, "Gripe", 7));
		sintomas.add(new Sintoma(210, "Tos", 9));
		sintomas.add(new Sintoma(220, "Fiebre", 5));
		sintomas.add(new Sintoma(230, "Vomitos", 2));
		
		return sintomas;
	}
}
