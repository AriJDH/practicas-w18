package com.example.starwarsapi.repository;

import com.example.starwarsapi.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.xml.stream.events.Characters;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository{
    List<Personaje> personajes;

    public PersonajeRepositoryImp() {
        this.personajes = new ArrayList<>();
        loadList();
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            this.personajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public Personaje findOne(String nombre) {


        return null;
    }
}
