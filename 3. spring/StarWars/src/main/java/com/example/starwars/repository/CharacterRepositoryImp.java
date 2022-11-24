package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

@Repository
public class CharacterRepositoryImp implements ICharacterRepository {
    List<Personaje> personajes = new ArrayList<>();

    @Override
    public List<Personaje> findAllByName(String name){
        return personajes.stream().filter(c ->);
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File  jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            this.personajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
