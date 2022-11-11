package com.example.starwars.repositories;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository{

    List<Personaje> personajes;
    public PersonajeRepository(){
        this.personajes = new ArrayList<>();
        loadList();
    }

    @Override
    public List<Personaje> findAll(){

        return personajes;
    }

    @Override
    public void loadList(){
        SimpleModule simpleModule = new SimpleModule().addDeserializer(String.class, new EmptyStringDeserializer());
        ObjectMapper mapper = new ObjectMapper().registerModule(simpleModule);
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(jsonFile,new TypeReference<List<Personaje>>(){});
        }catch(Exception ex){
            System.out.println("No existe el archivo. "+ ex.getMessage());
        }


    }

}
