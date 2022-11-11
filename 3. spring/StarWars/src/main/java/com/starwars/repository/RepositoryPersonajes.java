package com.starwars.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Characters;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.model.Personaje;

@Repository
public class RepositoryPersonajes implements IRepositortyPersonaje{
	
	private List<Characters> listOfChars;
	 ObjectMapper mapper = new ObjectMapper();
	private void loadList(){
       
        File  jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<Characters>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

	@Override
	public List<Personaje> getByName(String name) {
		List<Personaje>personajeList=new ArrayList<>();
		listOfChars.forEach(p -> personajeList.add(mapper.convertValue(p,Personaje.class)));
        return personajeList;
	}

}
