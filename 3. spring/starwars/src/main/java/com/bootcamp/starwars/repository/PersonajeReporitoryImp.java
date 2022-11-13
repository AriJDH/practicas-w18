package com.bootcamp.starwars.repository;


import com.bootcamp.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeReporitoryImp implements IPersonajeRepository {
    List<Personaje> personajes = new ArrayList<>();

    public PersonajeReporitoryImp() {
        loadList();
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    @Override
    public List<Personaje> findByName(String name) {

        return personajes.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .collect(Collectors.toList());
    }
}
