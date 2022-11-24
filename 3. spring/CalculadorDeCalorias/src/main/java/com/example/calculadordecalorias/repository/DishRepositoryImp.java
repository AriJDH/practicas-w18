package com.example.calculadordecalorias.repository;

import com.example.Calorias.entity.Dish;
import com.example.Calorias.entity.Ingredient;
import com.example.calculadordecalorias.entity.Dish;
import com.example.calculadordecalorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepositoryImp implements IDishRepository{
    List<Dish> dishes;
    List<Ingredient> ingredients;

    public DishRepositoryImp() {
        this.dishes=new ArrayList<>();
        this.ingredients=new ArrayList<>();
        loadList();
        createDish();
    }

    @Override
    public Dish findDishByName(String name) {
        return dishes.stream().filter(dish -> dish.getName().equals(name)).findFirst().get();
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

    private void createDish(){
        int maxIngredients=5;
        int minIngredients=1;
        //Creamos una cantidad de platos = 10
        for (int i = 0; i < 10; i++) {
            //Creamos una lista de ingredientes para cada plato.
            List<Ingredient> ingredientsDish= new ArrayList<>();
            //Calculamos un número random de ingredientes para dada plato.
            int countIngredients = (int) ((Math.random() * (maxIngredients - minIngredients)) + minIngredients);
            //Agregamos a cada plato los ingredientes.
            for (int j = 0; j < countIngredients; j++) {
                //Seleccionamos un ingrediente random de la lista de ingredientes (food.json)
                int indexIngredients = (int) ((Math.random() * (ingredients.size()-1)));
                ingredientsDish.add(ingredients.get(indexIngredients));
            }
            //Creamos el plato
            dishes.add(new Dish("Plato"+i,ingredientsDish));
        }
    }
}
