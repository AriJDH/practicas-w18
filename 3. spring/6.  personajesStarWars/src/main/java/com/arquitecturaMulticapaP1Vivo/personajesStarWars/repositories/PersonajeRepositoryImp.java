package com.arquitecturaMulticapaP1Vivo.personajesStarWars.repositories;

import com.arquitecturaMulticapaP1Vivo.personajesStarWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository {
	
		List<Personaje> personajes;
	
	public PersonajeRepositoryImp(List<Personaje> personajes) {
		this.personajes = personajes;
		loadList();
	}
	
	public PersonajeRepositoryImp() {
	
	}
	
	@Override
	public List<Personaje> findAll(){
		loadList();
		return personajes;
	}
	
	@Override
	public void loadList(){
		ObjectMapper mapper = new ObjectMapper();
		File jsonFile;
		try {
			jsonFile = ResourceUtils.getFile("classpath:starwars.json");
			personajes = mapper.readValue(jsonFile,new TypeReference<List<Personaje>>(){});
		}catch(Exception ex){
			System.out.println("No existe el archivo. "+ ex.getMessage());
		}
		
		
	}
	
}
