package com.bootcamp.testing.dto.response;


import com.bootcamp.testing.dto.IngredientRecipeDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DishResponseDTO {
  private String                    name;
  private String                    description;
  private List<IngredientRecipeDTO> ingredients;
  private Double                    quality;
  private Double                    calories;
}
