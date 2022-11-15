package com.example.calculadoracalorias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ingrediente {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("calories")
    private Integer calorias;
}
