package com.example.empresadeseguros.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoConSiniestrosDTOResponse {
    private Integer id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private Integer ruedas;
    private Set<SiniestroSinIdDTOResponse> siniestros;
}
