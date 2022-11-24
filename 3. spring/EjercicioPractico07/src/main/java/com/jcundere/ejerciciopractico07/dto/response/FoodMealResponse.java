package com.jcundere.ejerciciopractico07.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodMealResponse {

    private List<FoodResponse> foodResponseList;
    private String amountTotalCalories;
    private FoodResponse ingredientWithMoreCalories;

}
