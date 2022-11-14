package com.example.CalculadoraDeCalorias.repository;

import com.example.CalculadoraDeCalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;

@Repository
public class IngredientesRepositoryImp implements IIngredienteRepository{

    private List<Ingrediente> listaDeIngredientes;

    @Override
    public List<Ingrediente> findAll() {
        return listaDeIngredientes;
    }

    @Override
    public Ingrediente findByName(String name) {
        Ingrediente ingrediente = listaDeIngredientes.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        return ingrediente;
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            listaDeIngredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

}
