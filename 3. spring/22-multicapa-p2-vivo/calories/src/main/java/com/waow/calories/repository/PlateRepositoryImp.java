package com.waow.calories.repository;

import com.waow.calories.entity.Ingredient;
import com.waow.calories.entity.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class PlateRepositoryImp implements IPlateRepository{
    private List<Plate> plateList = new ArrayList<>();

    @Autowired
    IIngredientRepository ingredientRepository;

    public PlateRepositoryImp() {
        ingredientRepository = new IngredientRepositoryImp();
        loadList();
    }

    @Override
    public Optional<Plate> findPlateByName(String name) {
        return plateList.stream()
                .filter(plate -> plate.getName().equals(name))
                .findFirst();
    }

    private void loadList(){
        Map<Ingredient, Integer> ingredientIntegerMap1 = new HashMap<>();
        ingredientIntegerMap1.put(ingredientRepository.findIngredient("Cereza").orElseThrow(), 80);
        ingredientIntegerMap1.put(ingredientRepository.findIngredient("Pato").orElseThrow(), 400);
        ingredientIntegerMap1.put(ingredientRepository.findIngredient("Miel").orElseThrow(), 20);
        plateList.add(new Plate("duck", ingredientIntegerMap1));
        Map<Ingredient, Integer> ingredientIntegerMap2 = new HashMap<>();
        ingredientIntegerMap2.put(ingredientRepository.findIngredient("Langostino").orElseThrow(), 200);
        ingredientIntegerMap2.put(ingredientRepository.findIngredient("Salsa de soja").orElseThrow(), 20);
        plateList.add(new Plate("fish", ingredientIntegerMap2));
        Map<Ingredient, Integer> ingredientIntegerMap3 = new HashMap<>();
        ingredientIntegerMap3.put(ingredientRepository.findIngredient("Tomates").orElseThrow(), 100);
        ingredientIntegerMap3.put(ingredientRepository.findIngredient("Huevo duro").orElseThrow(), 50);
        ingredientIntegerMap3.put(ingredientRepository.findIngredient("Ciervo").orElseThrow(), 200);
        ingredientIntegerMap3.put(ingredientRepository.findIngredient("Tira de asado").orElseThrow(), 200);
        plateList.add(new Plate("braai", ingredientIntegerMap3));
    }
}
