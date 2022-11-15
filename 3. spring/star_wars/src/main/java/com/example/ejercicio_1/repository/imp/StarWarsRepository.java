package com.example.ejercicio_1.repository.imp;

import com.example.ejercicio_1.entity.Personaje;
import com.example.ejercicio_1.repository.IStarWarsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository implements IStarWarsRepository {

    List<Personaje> personajes = new ArrayList<>();

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(jsonFile, new TypeReference<>() {
            });
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
