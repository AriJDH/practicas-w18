package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.require.DishDTOreq;
import com.example.calculadoracalorias.dto.require.DishToPostDTOreq;
import com.example.calculadoracalorias.dto.response.DishDTOres;
import com.example.calculadoracalorias.entity.Dish;
import com.example.calculadoracalorias.entity.Ingredient;
import com.example.calculadoracalorias.repository.DishRepository;
import com.example.calculadoracalorias.repository.IDishRepository;
import com.example.calculadoracalorias.repository.IIngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DishService implements IDishService{

    private final IDishRepository dishRepository;
    private final IIngredientRepository ingredientsRepository;
    private final ModelMapper mapper;

    public DishService(DishRepository dishRepository, IIngredientRepository ingredientsRepository, ModelMapper mapper) {
        this.dishRepository = dishRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.mapper = mapper;
    }

    @Override
    public Integer getDishCaloriesByName(String name) {
        //TO-DO: implement
        return null;
    }

    @Override
    public DishDTOres getDishByName(String name) {
        //TO-DO: implement
        return null;
    }

    @Override
    public Ingredient getDishWithMostCaloriesByName(String name) {
        //TO-DO: implement
        return null;
    }

    @Override
    public void addDish(DishToPostDTOreq dishDTO) {
        List<Ingredient> ingredients = ingredientsRepository.getIngredients()
                .stream()
                .filter(i -> dishDTO.getIngredientsName().contains(i.getName()))
                .collect(Collectors.toList());
        Dish dishToAdd = new Dish(dishDTO.getName(), ingredients, dishDTO.getWeight());
        dishRepository.addDish(dishToAdd);
    }

    @Override
    public DishDTOres getDish(DishDTOreq dishDTO) {
        Dish dish = dishRepository.getDish(dishDTO.getName(), dishDTO.getWeight());
        if (Objects.nonNull(dish)){

            Integer totalDishCalories = dish.getIngredients()
                    .stream()
                    .mapToInt(Ingredient::getCalories)
                    .sum();

            Ingredient ingredientWithMostCalories = dish.getIngredients()
                    .stream()
                    .sorted(Comparator.comparing(Ingredient::getCalories))
                    .collect(Collectors.toList())
                    .get(0);

            return new DishDTOres(totalDishCalories, dish.getIngredients(), ingredientWithMostCalories);
        }
        return null;
    }
    @Override
    public List<DishDTOres> findDishes(List<DishDTOreq> dishesDTOreq) {
        List<DishDTOres> dishesDTOres = new ArrayList<>();
        dishesDTOreq.forEach(d -> dishesDTOres.add(getDish(d)));
        return dishesDTOres;
    }
}
