package com.kotor.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotor.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository {

    List<Personaje> listOfChars = new ArrayList<>();

    public PersonajeRepositoryImp() {
        loadList();
    }

    @Override
    public List<Personaje> findAll() {
        return listOfChars;
    }

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> personajeMatch;
        personajeMatch = listOfChars.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .collect(Collectors.toList());
        return personajeMatch;
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
        File jsonFile;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
