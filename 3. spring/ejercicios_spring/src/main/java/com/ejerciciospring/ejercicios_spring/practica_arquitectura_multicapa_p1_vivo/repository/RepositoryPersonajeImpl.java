package com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.repository;

import com.ejerciciospring.ejercicios_spring.practica2_dto_response.model.Persona;
import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.entity.IntegerStringDeserialize;
import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryPersonajeImpl implements IRepository<Personaje> {

    private List<Personaje> personajes = new ArrayList<>();

    public RepositoryPersonajeImpl() {
        this.loadList();
    }

    @Override
    public List<Personaje> consultarEntidadPorNombre(String nombre) {
        return personajes.stream().filter(personaje -> this.contienePalabra(nombre, personaje)).collect(Collectors.toList());
    }

    private boolean contienePalabra(String query, Personaje personaje) {
        return personaje.getName().toUpperCase().contains(query.toUpperCase());
    }

    private void loadList() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        /*SimpleModule module = new SimpleModule();
        module.addDeserializer(Integer.class, new IntegerStringDeserialize());
        objectMapper.registerModule(module);**/

        TypeReference<List<Personaje>> typeRef = new TypeReference<>(){};
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
