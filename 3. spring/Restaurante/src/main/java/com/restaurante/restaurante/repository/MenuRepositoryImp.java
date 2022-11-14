package com.restaurante.restaurante.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.restaurante.entity.Ingrediente;
import com.restaurante.restaurante.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuRepositoryImp implements ImenuRepository{

    List<Plato> menu = new ArrayList<>();

    public MenuRepositoryImp(){
        loadMenu();
    }

    private void loadMenu() {

        List<Ingrediente> ingredientes = new ArrayList<>();
        List<Plato> platos= new ArrayList<>();
        ingredientes = loadList();
        if(!ingredientes.isEmpty()){
            Plato plato = new Plato();
            plato.setNombre("Plato1");
            plato.setIngredientes(ingredientes);
            plato.getIngredientes().remove(2);
            Plato plato2 = new Plato();
            plato2.setNombre("Plato2");
            plato2.setIngredientes(ingredientes);
            plato2.getIngredientes().remove(1);
            Plato plato3 = new Plato();
            plato3.setNombre("Plato3");
            plato3.setIngredientes(ingredientes);
            plato3.getIngredientes().remove(0);

            platos.add(plato);
            platos.add(plato2);
            platos.add(plato3);
        }

        menu.addAll(platos);
    }

    private List<Ingrediente> loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
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
        return this.menu;
    }
}
