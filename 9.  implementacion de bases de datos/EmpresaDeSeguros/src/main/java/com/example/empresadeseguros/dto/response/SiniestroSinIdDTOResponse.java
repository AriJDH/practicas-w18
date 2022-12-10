package com.example.empresadeseguros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroSinIdDTOResponse {
    private Integer id;
    private LocalDate fecha;
    private Double perdidaEconomica;
}
