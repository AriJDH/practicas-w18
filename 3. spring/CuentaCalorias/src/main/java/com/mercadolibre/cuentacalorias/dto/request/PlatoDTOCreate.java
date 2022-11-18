package com.mercadolibre.cuentacalorias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlatoDTOCreate {
    private String nombre;
    private List<String> ingredientes;
}
