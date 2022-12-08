package com.bootcamp.lasperlas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JewerlyDtoRequest {
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private Boolean poseePiedra;
}
