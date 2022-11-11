package com.example.demo.repository;

import com.example.demo.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository{

    private List<Personaje> personajeList = new ArrayList<>();

    public PersonajeRepository(){
        this.loadList();
    }

    @Override
    public List<Personaje> findAll() {
        return personajeList;
    }

    @Override
    public void loadList() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajeList = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() { });
        } catch (Exception e) {
            System.out.println("No existe el archivo "+e.getMessage());
        }
    }
}
