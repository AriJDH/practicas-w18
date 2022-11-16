package com.example.edad_persona.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeporteDto {
    private String nombre;
    private Integer nivel;
}
