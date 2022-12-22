package com.example.empleados.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoRequest {

    private String nombre;

    private String apellido;

    private Integer edad;

    private String ciudad;

    private String provincia;

}
