package com.jcundere.ejerciciopractico07.repository;

import com.jcundere.ejerciciopractico07.entity.Food;
import com.jcundere.ejerciciopractico07.utils.JsonReader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository {

    public static final List<Food> foodRepository = JsonReader.readAndParseJson("food.json");


    @Override
    public List<Food> getAll() {
        return foodRepository;
    }

    @Override
    public Food getByName(String name) {

        for (Food food : foodRepository) {
            if (food.getName().equalsIgnoreCase(name)) {
                return food;
            }
        }

        return null;
    }

    @Override
    public Food save(Food food) {
        foodRepository.add(food);
        return food;
    }

    @Override
    public Food update(String name, Food food) {

        Food foodObtained = getByName(name);
        if (foodObtained != null) {
            foodRepository.set(foodRepository.indexOf(foodObtained), food);
        }

        return null;
    }

    @Override
    public void deleteByName(String name) {

        Food foodObtained = getByName(name);
        if (foodObtained != null) {
            foodRepository.remove(foodObtained);
        }

    }

}
