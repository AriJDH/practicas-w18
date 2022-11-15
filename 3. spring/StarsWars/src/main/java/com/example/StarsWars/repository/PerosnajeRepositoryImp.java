package com.example.StarsWars.repository;

import com.example.StarsWars.entity.Personaje;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PerosnajeRepositoryImp implements IPersonajeRepository{
    private final List<Personaje> listOfpersonajes;

    public PerosnajeRepositoryImp() {
        this. listOfpersonajes = loadList();
    }

    @Override
    public List<Personaje> finAllPeronajes() {
        return listOfpersonajes;
    }

    //Cargar la lista a traves de un json.
    private List<Personaje> loadList(){
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> newListOfPersonaje = new ArrayList<>();
        File jsonFile = null;
        try{
            jsonFile = ResourceUtils.getFile("classpath:3. starwars.json");
            if(jsonFile == null)
                throw new IllegalArgumentException("El json no se leyo correctamente");
            newListOfPersonaje = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>(){});


        }catch (Exception ex){
            System.out.println("No exsiste el arhcivo." + ex.getMessage());
        }
        return newListOfPersonaje;
    }
}
