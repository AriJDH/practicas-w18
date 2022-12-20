package com.example.segurosautos.dto;

import com.example.segurosautos.entity.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDto {

    private String patente;
    private String Marca;
    private String Modelo;
    private Integer anioFabricacion;
    private Integer ruedas;
}
