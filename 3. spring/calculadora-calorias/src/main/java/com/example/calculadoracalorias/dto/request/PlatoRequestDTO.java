package com.example.calculadoracalorias.dto.request;

import com.example.calculadoracalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PlatoRequestDTO {
    private String name;
    private List<IngredienteRequestDTO> ingredienteList;
}
