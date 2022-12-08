package com.arquitecturaMulticapaP1Vivo.personajesStarWars.repositories;

import com.arquitecturaMulticapaP1Vivo.personajesStarWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository {
	List<Personaje> personajes = new ArrayList<>();
	
	public PersonajeRepositoryImp(List<Personaje> personajes) {
		this.personajes = personajes;
	}
	
	@Override
	public List<Personaje> findAll() {
		loadList();
		return personajes;
	}
	
	@Override
	public void loadList() {
		File jsonFile = null;
		try {
			jsonFile = ResourceUtils.getFile("classpath:starwars.json");
			String strList = Files.readAllLines(jsonFile.toPath()).stream().collect(Collectors.joining("\n"));
			strList = strList.replace("\"NA\"", "0");
			ObjectMapper om = new ObjectMapper();
			personajes = om.readValue(strList, new TypeReference<List<Personaje>>() {});
		} catch (Exception ex) {
			System.out.println("No puede leerse el archivo. " + ex.getMessage());
		}
		
		
	}
	
}
