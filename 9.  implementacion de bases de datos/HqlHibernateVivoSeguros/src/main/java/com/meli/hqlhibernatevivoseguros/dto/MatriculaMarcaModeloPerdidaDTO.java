package com.meli.hqlhibernatevivoseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatriculaMarcaModeloPerdidaDTO {
    private String matricula;
    private String marca;
    private String modelo;
    private Double perdidaEconomica;
}
