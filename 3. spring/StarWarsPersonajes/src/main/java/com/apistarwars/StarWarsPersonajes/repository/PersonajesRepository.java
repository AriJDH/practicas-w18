package com.apistarwars.StarWarsPersonajes.repository;

import com.apistarwars.StarWarsPersonajes.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajesRepository implements IPersonajesRepository {

    List<Personaje> listaPersonajes = new ArrayList<>();

    public PersonajesRepository(){
        cargar();
    }
    @Override
    public List<Personaje> retornarListaPersonajes(){
        return listaPersonajes;
    }

    private void cargar(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listaPersonajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
