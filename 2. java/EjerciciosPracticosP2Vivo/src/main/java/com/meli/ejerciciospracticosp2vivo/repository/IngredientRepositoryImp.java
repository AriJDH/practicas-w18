package com.meli.ejerciciospracticosp2vivo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ejerciciospracticosp2vivo.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Repository
public class IngredientRepositoryImp implements IIngredientRepository {

    private List<Ingredient> foodList;

    public IngredientRepositoryImp(){
        loadData();
    }

    @Override
    public List<Ingredient> getIngredientAll() {
        return foodList;
    }

    private void loadData(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:static/food.json");
            foodList = mapper.readValue(jsonFile, new TypeReference<List<Ingredient>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
