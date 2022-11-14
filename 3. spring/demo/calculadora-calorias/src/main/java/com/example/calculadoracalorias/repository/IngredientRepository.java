package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredientRepository {

    public List<Ingredient> ingredients;


    public IngredientRepository() {
        loadIngredients();
    }

    public void loadIngredients(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredients = mapper.readValue(jsonFile, new TypeReference<List<Ingredient>>() {});
        } catch (Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public Ingredient getIngredient(String name) {
        for (Ingredient ingredient: ingredients) {
            if(ingredient.getName().equals(name))
                return ingredient;
        }
        return null;
    }
}
