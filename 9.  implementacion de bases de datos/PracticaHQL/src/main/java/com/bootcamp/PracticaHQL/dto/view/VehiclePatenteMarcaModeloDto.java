package com.bootcamp.PracticaHQL.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VehiclePatenteMarcaModeloDto {
    private String patente;
    private String marca;
    private String modelo;
}
