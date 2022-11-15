package com.example.calculadoracalorias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PlatoRequestPesoDTO {
    private String name;
    private Integer peso;
}
