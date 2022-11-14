package com.spring.calculadoracalorias.dto;

import com.spring.calculadoracalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlatoDTO {
    private Integer caloriasTotales;
    private List<Ingrediente> ingredientes;
    private  Ingrediente ingMaximasCalorias;
}
