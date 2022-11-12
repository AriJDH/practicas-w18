package com.example.StarsWars.repository;

import com.example.StarsWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PerosnajeRepositoryImp implements IPersonajeRepository{
    private List<Personaje> listOfpersonajes = new ArrayList<>();

    public PerosnajeRepositoryImp() {
        loadList();
    }

    @Override
    public List<Personaje> finAllPeronajes() {
        return listOfpersonajes;
    }


    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File("null");
        try{
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listOfpersonajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>(){});

        }catch (Exception ex){
            System.out.println("No exsiste el arhcivo." + ex.getMessage());
        }

    }
}
