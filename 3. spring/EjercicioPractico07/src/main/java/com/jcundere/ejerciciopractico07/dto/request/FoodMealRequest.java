package com.jcundere.ejerciciopractico07.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FoodMealRequest {

    @JsonProperty("food_name_list")
    private List<String> foodNameList;

}
