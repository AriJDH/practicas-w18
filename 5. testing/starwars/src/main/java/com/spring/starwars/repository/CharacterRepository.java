package com.spring.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository{

    List<Personaje> listOfChars = new ArrayList<>();

    public CharacterRepository() {
        loadList();
    }

    @Override
    public List<Personaje> findCharacters(String name) {
        return listOfChars.stream()
                .filter(p -> p.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Personaje> getAllCharacters() {
        return listOfChars.stream()
                .collect(Collectors.toList());
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
