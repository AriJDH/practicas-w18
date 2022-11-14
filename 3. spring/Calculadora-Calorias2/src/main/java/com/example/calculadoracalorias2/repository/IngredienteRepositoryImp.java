package com.example.calculadoracalorias2.repository;

import com.example.calculadoracalorias2.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredienteRepositoryImp implements IIngredienteRepository{

    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImp() {
        this.ingredientes = new ArrayList<>();
        loadList();
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            this.ingredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
