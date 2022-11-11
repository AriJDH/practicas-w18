package com.example.pr_multicapa_grupal_starwars.repository;

import com.example.pr_multicapa_grupal_starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.xml.stream.events.Characters;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository{

    private List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepositoryImp(){
        loadList();
    }

    @Override
    public List<Personaje> findByName(String name) {
        return personajes.stream().filter(x->x.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
    }

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
