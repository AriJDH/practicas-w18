package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository{

    private List<Personaje> personajes;

    public PersonajeRepository() {
        cargarPersonajes();
    }

    @Override
    public List<Personaje> getPersonajes() {
        return null;
    }

    @Override
    public List<Personaje> getPersonajesByName(String name) {
        List<Personaje> personajesFiltrados = personajes
                .stream()
                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList());
        return personajesFiltrados;
    }
    private void cargarPersonajes(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }


}
