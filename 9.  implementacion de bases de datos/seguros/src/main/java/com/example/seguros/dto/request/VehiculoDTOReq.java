package com.example.seguros.dto.request;

import com.example.seguros.model.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTOReq {
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int ruedas;
}
