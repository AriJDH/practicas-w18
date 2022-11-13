package com.example.starwarsmulticapa.repository;

import com.example.starwarsmulticapa.dto.request.PersonajeDTO;
import com.example.starwarsmulticapa.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository {
    List<Personaje> personajes;

    public PersonajeRepositoryImp() {
        this.personajes = cargarDatos();
    }

    private List<Personaje> cargarDatos() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};

        List<Personaje> listPersonajes = null;
        try {
            listPersonajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listPersonajes;
    }


    @Override
    public List<Personaje> listSelectPersonajes(String name) {
        List<Personaje> resultado = personajes.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .collect(Collectors.toList());

       return resultado;
    }


}
