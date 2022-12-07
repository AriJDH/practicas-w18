package com.example.siniestros.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloTotalDTO {
    private List<PatenteMarcaModeloDTO> vehiculos;
    private Double total;
}
