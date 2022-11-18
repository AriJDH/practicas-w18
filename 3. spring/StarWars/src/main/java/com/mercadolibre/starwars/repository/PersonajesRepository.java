package com.mercadolibre.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajesRepository implements IPersonajesRepository {
    private List<Personaje> personajes;

    public PersonajesRepository(){
        this.loadList();
    }

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public List<Personaje> findByName(String name) {
        String nameLoweCase = name.toLowerCase();
        return this.personajes.stream()
                .filter(p-> p.getName().toLowerCase().contains(nameLoweCase))
                .collect(Collectors.toList());
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            this.personajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>(){});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
