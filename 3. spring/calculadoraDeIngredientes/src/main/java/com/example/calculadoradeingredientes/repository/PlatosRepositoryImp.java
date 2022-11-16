package com.example.CalculadoraDeIngredientes.repository;

import com.example.CalculadoraDeIngredientes.entity.Ingrediente;
import com.example.CalculadoraDeIngredientes.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatosRepositoryImp implements IPlatosRepository{

    private List<Plato> platos;

    public PlatosRepositoryImp() {
        loadPlato();
    }

    private void loadPlato(){
        List<Ingrediente> ingredientes = loadList();

        for (int i = 0; i < 5; i++) {
            List<Ingrediente> ingredientePlato = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int indice = (int)(Math.random() * ingredientes.size());
                ingredientePlato.add(ingredientes.get(indice));
            }
            String nombrePlato = "Plato " + i;
            Plato nuevoPlato = new Plato(nombrePlato, ingredientePlato);
            platos.add(nuevoPlato);
        }
    }

    private List<Ingrediente> loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        List<Ingrediente> ingredientes = new ArrayList<>();
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }

        return ingredientes;
    }

    @Override
    public List<Plato> getAll() {
        return platos;
    }
}
