package com.restaurante.restaurante.dto;

import com.restaurante.restaurante.entity.Ingrediente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class MenuDto {
    Double cargaCalorica;
    List<Ingrediente> ingredientes;
    Ingrediente ingredienteMaxCalorias;
}
