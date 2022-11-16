package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.xml.stream.events.Characters;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
@Getter
public class PersonajeRepositoryImpl implements IPersonajeRepository{

    private List<Personaje> listOfChars;
    ObjectMapper mapper = new ObjectMapper();

    public PersonajeRepositoryImpl() {
        loadList();
    }



    private void loadList(){

        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> personajeList = new ArrayList<>();
        personajeList = listOfChars.stream()
                .filter(personaje -> personaje.getName().matches(name))
                .collect(Collectors.toList());
        return personajeList;
    }
}
