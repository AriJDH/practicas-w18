package com.example.empresadeseguros.dto.request;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroNewDTORequest {
    private LocalDate fecha;
    private Double perdidaEconomica;
    private Integer vehiculo_id;
}
