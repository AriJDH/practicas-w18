package com.example.StarWars.repository;

import com.example.StarWars.dto.response.PersonalityDTO;
import com.example.StarWars.entity.Personality;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonalityRepositoryImp implements IPersonalityRepository {
    List<Personality> personalities = new ArrayList<>();

    public PersonalityRepositoryImp() {
        loadList();
    }

    @Override
    public List<Personality> findAllByName(String name) {
        List<Personality> results = new ArrayList<>();
        for(Personality personality : personalities){
            if(personality.getName().contains(name)){
                results.add(personality);
            }
        }
        return results;

    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            personalities = mapper.readValue(jsonFile, new TypeReference<List<Personality>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
