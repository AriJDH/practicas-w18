package com.meli.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.entity.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImp implements ICharacterRepository{

    private List<Character> listOfChars;

    public CharacterRepositoryImp(){
        loadList();
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:static/starwars.json");
            listOfChars = mapper.readValue(jsonFile, new TypeReference<List<Character>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    @Override
    public List<Character> getAllCharacterContainingName(String name) {
        return listOfChars.stream().
                filter( c -> c.getName().contains(name)).collect(Collectors.toList());
    }
}
