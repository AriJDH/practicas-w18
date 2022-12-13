package com.example.seguros.dto.response;

import com.example.seguros.model.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTORes {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int ruedas;
}
