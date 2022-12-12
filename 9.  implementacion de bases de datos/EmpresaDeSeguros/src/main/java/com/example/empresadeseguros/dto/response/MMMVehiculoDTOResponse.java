package com.example.empresadeseguros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MMMVehiculoDTOResponse {
    private String patente;
    private String marca;
    private String modelo;
}
