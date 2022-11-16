package com.example.calculadora.repository.impl;

import com.example.calculadora.entity.Ingredient;
import com.example.calculadora.repository.IIngredientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredientRepository {

    List<Ingredient> ingredients = new ArrayList<>();

    public IngredientRepository() {
        loadList();
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredients = mapper.readValue(jsonFile, new TypeReference<>() {
            });
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
