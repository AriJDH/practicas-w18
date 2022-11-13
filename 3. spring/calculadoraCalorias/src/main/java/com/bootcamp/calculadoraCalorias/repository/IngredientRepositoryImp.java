package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepositoryImp implements IIngredientRepository{
    List<Ingredient>ingredients=new ArrayList<>();

    public IngredientRepositoryImp() {
        loadList();
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredients = mapper.readValue(jsonFile, new TypeReference<List<Ingredient>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
    public List<Ingredient> getIngredients(){
        return ingredients;
    }




}
