package com.example.deportistas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Deporte {
    private String nombre;
    private NivelDeporte nivelDeporte;
}
