package com.example.starwars.repository;

import com.example.starwars.entity.Character;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.xml.stream.events.Characters;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CharacterRepository implements ICharacterRepository{

    List<Character> characters = new ArrayList<>();
    public CharacterRepository(){
        loadList();
    }

    /*private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File  jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            characters = mapper.readValue(jsonFile, new TypeReference<List<Character>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }*/

    private void loadList(){
        Character character = new Character("Luke Skywalker","172","77","blond","fair","blue","19BBY","male","Tatooine","Human");
        Character character1 = new Character("C-3PO","167","75","NA","GOLD","YELLOW","11BY","NA","TATOOINE","DROID");

        characters.add(character);
        characters.add(character1);


    }

    @Override
    public List<Character> findAllCharacters() {
        return characters;
    }

}
