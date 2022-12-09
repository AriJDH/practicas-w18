package com.example.hql2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehiculoResponse {

    private String patente;
    private String marca;
    private String modelo;

    public VehiculoResponse(String patente) {
        this.patente = patente;
    }

    public VehiculoResponse(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }

}
