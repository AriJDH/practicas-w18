package com.example.starwarsjson.repositories;

import com.example.starwarsjson.Config;
import com.example.starwarsjson.entities.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository extends JsonRepository<Personaje>{
    public PersonajeRepository() {
        super(Config.PERSONAJES_FILE_NAME, new TypeReference<List<Personaje>>(){});
    }
    public List<Personaje> findByName(String name){
        return  super.findAll().stream().filter(personaje -> personaje.getName().contains(name))
                .collect(Collectors.toList());
    }
}
