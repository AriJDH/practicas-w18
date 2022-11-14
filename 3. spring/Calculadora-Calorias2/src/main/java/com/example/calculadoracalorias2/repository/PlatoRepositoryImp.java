package com.example.calculadoracalorias2.repository;

import com.example.calculadoracalorias2.entity.Ingrediente;
import com.example.calculadoracalorias2.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlatoRepositoryImp implements IPlatoRepository{


    private List<Plato> platos;

    public PlatoRepositoryImp() {
        this.platos = new ArrayList<>();
        createDish();
    }

    @Override
    public Plato findOne(String nombre) {
        return this.platos.stream().filter(p -> encontrado(nombre, p)).findFirst().get();
    }

    @Override
    public double calcularTotalCalorias(String nombrePlato) {
        double total = 0;
        for (Plato p: this.platos){
            if(encontrado(nombrePlato, p)){
                System.out.println("PAseor acaa");
                for (int i = 0; i < p.getIngredientes().size(); i++){
                    total += p.getIngredientes().get(i).getCalories();
                }
            }
        }
        return total;
    }

    @Override
    public List<Ingrediente> listaIngredientes(String nombrePlato) {
        List<Ingrediente> ingredientes = new ArrayList<>();

        for(Plato p: this.platos){
            if(encontrado(nombrePlato, p)){
                ingredientes = p.getIngredientes();
            }
        }

        return ingredientes;
    }

    @Override
    public Ingrediente maxCalorias(String nombre){
        Ingrediente ingredienteMax = new Ingrediente("centinela", Double.MIN_VALUE);
        for (Plato p: this.platos) {
            if(encontrado(nombre, p)){
                for (int i = 0; i < p.getIngredientes().size(); i++) {
                    if(ingredienteMax.getCalories() < p.getIngredientes().get(i).getCalories()){
                        ingredienteMax = p.getIngredientes().get(i);
                    }
                }
            }
        }

        return ingredienteMax;
    }



    private boolean encontrado(String nombrePlato, Plato plato){
        return plato.getName().toUpperCase().equals(nombrePlato.toUpperCase());
    }


    private void createDish(){
        int maxIngredients=5;
        int minIngredients=1;

        ObjectMapper mapper = new ObjectMapper();
        List<Ingrediente> ingredientes = new ArrayList<>();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
        //Creamos una cantidad de platos = 10
        for (int i = 0; i < 10; i++) {
            //Creamos una lista de ingredientes para cada plato.
            List<Ingrediente> ingredientsDish = new ArrayList<>();
            //Calculamos un número random de ingredientes para dada plato.
            int countIngredients = (int) ((Math.random() * (maxIngredients - minIngredients)) + minIngredients);
            //Agregamos a cada plato los ingredientes.
            for (int j = 0; j < countIngredients; j++) {
                //Seleccionamos un ingrediente random de la lista de ingredientes (food.json)
                int indexIngredients = (int) ((Math.random() * (ingredientes.size()-1)));
                ingredientsDish.add(ingredientes.get(indexIngredients));
            }
            //Creamos el plato
            this.platos.add(new Plato("Plato "+i, ingredientsDish));
        }
    }
}
