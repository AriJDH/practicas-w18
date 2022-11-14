package com.example.calculadoracalorias.dto.require;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishToPostDTOreq {

    private String name;
    private List<String> ingredientsName;
    private Double weight;

}
