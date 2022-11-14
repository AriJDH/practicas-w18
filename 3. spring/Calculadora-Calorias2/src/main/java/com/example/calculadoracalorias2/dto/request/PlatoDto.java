package com.example.calculadoracalorias2.dto.request;

import com.example.calculadoracalorias2.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PlatoDto {
    private double totalCalorias;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMax;

}
