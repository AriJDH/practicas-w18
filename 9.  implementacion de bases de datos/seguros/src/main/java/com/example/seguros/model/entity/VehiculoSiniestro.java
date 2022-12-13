package com.example.seguros.model.entity;

import com.example.seguros.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestro {
    private Vehiculo vehiculo;
    private Double perdidaTotal;
}
