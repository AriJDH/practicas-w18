package com.waow.calories.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waow.calories.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImp implements IIngredientRepository{
    List<Ingredient> ingredientList = new ArrayList<>();

    public IngredientRepositoryImp() {
        loadList();
    }

    @Override
    public Optional<Ingredient> findIngredient(String name) {
        return ingredientList.stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findFirst();
    }

    private void loadList(){
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            ingredientList = mapper.readValue(jsonFile, new TypeReference<List<Ingredient>>() {});
        }catch (Exception ex){
            System.out.println("FILE MAPPER ERROR: " + ex.getMessage());
        }
    }
}
