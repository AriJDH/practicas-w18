package com.example.calculadoradecalorias.repository;

import com.example.calculadoradecalorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepositoryImp implements IIngredientRepository {

    private List<Ingredient> ingredients;

    public IngredientRepositoryImp(){
        this.ingredients = new ArrayList<>();
        loadList();
    }

    @Override
    public List<Ingredient> findAll(){
        return ingredients;
    }

    private void loadList() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;

        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredients = mapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (Exception ex) {
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
