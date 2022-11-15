package com.apicalorias.CalculadoraCalorias.dto;

import com.apicalorias.CalculadoraCalorias.entity.Ingrediente;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PlatoRequestDTO {
    private String nombre;
    private List<String> ingredientes;
}
