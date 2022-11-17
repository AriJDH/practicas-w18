package com.meli.ejerciciospracticosp2vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class DishResponseDTO {
    private String name;
    private Double totalCalories;
}
