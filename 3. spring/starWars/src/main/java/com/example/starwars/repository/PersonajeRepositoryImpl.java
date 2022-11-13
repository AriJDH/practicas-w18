package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.xml.stream.events.Characters;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository{

        private List<Personaje> personajes;

    ObjectMapper mapper = new ObjectMapper();

        public PersonajeRepositoryImpl(){
            this.loadList();
        }

    private void loadList(){

        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>(){});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    @Override
    public List<Personaje> findByName(String name) {
        String nameLoweCase = name.toLowerCase();
        return this.personajes.stream()
                .filter(p-> p.getName().toLowerCase().contains(nameLoweCase))
                .collect(Collectors.toList());
    }
}
