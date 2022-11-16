package com.example.starwars.repository;


import com.example.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository {
private List<Personaje> listOfChars;


    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    public PersonajeRepository(){
        loadList();
    }


    @Override
    public List<Personaje> getChars(String busqueda) {
//        List<Personaje> retorno = listOfChars.stream().filter(p->p.getName().contains(busqueda)).collect(Collectors.toList());

        return listOfChars;
    }
}
