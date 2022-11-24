package com.jcundere.ejerciciopractico07.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcundere.ejerciciopractico07.dto.response.FoodResponse;
import com.jcundere.ejerciciopractico07.entity.Food;

public class FoodMapper {

    public static FoodResponse entityToResponse(Food food) {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(food, FoodResponse.class);
    }

}
