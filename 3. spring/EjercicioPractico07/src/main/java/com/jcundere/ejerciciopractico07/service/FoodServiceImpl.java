package com.jcundere.ejerciciopractico07.service;

import com.jcundere.ejerciciopractico07.dto.response.FoodMealResponse;
import com.jcundere.ejerciciopractico07.entity.Food;
import com.jcundere.ejerciciopractico07.repository.IFoodRepository;
import com.jcundere.ejerciciopractico07.utils.FoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements IFoodService {

    private final IFoodRepository iFoodRepository;

    @Override
    public FoodMealResponse calculateCaloriesTotal(List<String> foodMeals) {

        List<Food> foodList = foodMeals
                .stream()
                .map(food -> {Food foodObtained = iFoodRepository.getByName(food);

                    return foodObtained != null ? foodObtained : Food.builder().calories(0).name(food + " NOT FOUND").build();})
                .collect(Collectors.toList());

        Food foodWithMoreCalories = foodList
                .stream()
                .max(Comparator.comparing(Food::getCalories))
                .orElse(null);

        Integer caloriesTotal = foodList
                .stream()
                .mapToInt(Food::getCalories)
                .sum();

        return FoodMealResponse
                .builder()
                .foodResponseList(foodList.stream().map(FoodMapper::entityToResponse).collect(Collectors.toList()))
                .amountTotalCalories(String.format("🍕🍻 The total amount of calories is %s", caloriesTotal))
                .ingredientWithMoreCalories(FoodMapper.entityToResponse(foodWithMoreCalories))
                .build();

    }

}
