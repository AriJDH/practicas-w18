package com.calorias.calorias.dto;

import com.calorias.calorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponsePlatoDTO {

    double caloriasTotales;
    List<Ingrediente> ingredientes;
    Ingrediente ingMasCalorias;

}
