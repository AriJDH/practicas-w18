package com.bootcamp.lasperlas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JewerlyDtoResponse {
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
