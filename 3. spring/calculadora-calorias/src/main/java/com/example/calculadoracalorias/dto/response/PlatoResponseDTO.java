package com.example.calculadoracalorias.dto.response;

import java.util.Comparator;
import java.util.List;

public class PlatoResponseDTO {
    private String name;
    private List<IngredienteResponseDTO> ingredienteList;
    private Integer totalCalories;
    private String ingredienteMasCalorico;

    public PlatoResponseDTO(String name, List<IngredienteResponseDTO> ingredienteList, Integer totalCalories, String ingredienteMasCalorico) {
        this.name = name;
        this.ingredienteList = ingredienteList;
        this.totalCalories = calcularCalories();
        this.ingredienteMasCalorico = ingredienteCalorico();
    }

    private Integer calcularCalories(){
        return ingredienteList.stream().map(x-> x.getCalories()).reduce(Integer::sum).orElse(0);
    }

    private String ingredienteCalorico (){
        return ingredienteList.stream().max(Comparator.comparing(x->x.getCalories())).get().getName();
    }
}
