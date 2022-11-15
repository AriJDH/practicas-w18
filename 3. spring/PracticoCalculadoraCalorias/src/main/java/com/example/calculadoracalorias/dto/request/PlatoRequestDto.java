package com.example.calculadoracalorias.dto.request;

import com.example.calculadoracalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlatoRequestDto {
    private String nombre;
    private float peso;
    private List<Ingrediente> ingredientesList;
    private float totalCalorias;
}
