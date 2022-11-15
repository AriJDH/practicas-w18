package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Repository
public class IngredienteRepository implements IIngredienteRepository{
    List<Ingrediente> ingredientes;
    @Override
    public List<Ingrediente> loadList() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            this.ingredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
        return ingredientes;
    }
}
