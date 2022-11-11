package com.kotor.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kotor.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
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
        return listOfChars.stream()
                .filter(personaje -> personaje.getName()
                        .toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    private void loadList(){
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
