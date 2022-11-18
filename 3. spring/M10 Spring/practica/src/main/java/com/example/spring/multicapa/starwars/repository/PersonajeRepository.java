package com.example.spring.multicapa.starwars.repository;

import com.example.spring.multicapa.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements IPersonajeRepository {


    List<Personaje> personajes;

    public PersonajeRepository() {
        this.personajes = new ArrayList<>();
        loadList();
    }

    @Override
    public List<Personaje> findAll() {
        return personajes;
    }

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> personajesPorNombre = new ArrayList<>();

        for (Personaje p: personajes) {
            if (p.getName().contains(name)){
                personajesPorNombre.add(p);
            }
        }

        return personajesPorNombre;
    }

    private void loadList() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;

        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (Exception ex) {
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
