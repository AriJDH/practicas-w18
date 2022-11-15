package com.apicalorias.CalculadoraCalorias.repository;

import com.apicalorias.CalculadoraCalorias.dto.IngredienteDTO;
import com.apicalorias.CalculadoraCalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientesRepository implements IIngredientesRepository {
    List<Ingrediente> listaIngredientes= new ArrayList<>();

    public IngredientesRepository(){
        cargarIngredientes();
    }

    @Override
    public List<Ingrediente> retornarListaIngredientes(){
        return listaIngredientes;
    }

    public void cargarIngredientes(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            listaIngredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }


}


