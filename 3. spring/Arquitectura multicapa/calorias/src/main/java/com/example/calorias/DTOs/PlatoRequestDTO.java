package com.example.calorias.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoRequestDTO {
    private String nombre;
    private List<String> ingredientes;
    private double gramos;
}
