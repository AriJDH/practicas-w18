package com.example.starwars.repositories;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(jsonFile,new TypeReference<List<Personaje>>(){});
        }catch(Exception ex){
            System.out.println("No existe el archivo. "+ ex.getMessage());
        }


    }

}
