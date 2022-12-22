package com.example.empleados.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoResponse {

    private String nombre;

    private String apellido;

    private Integer edad;

    private String ciudad;

    private String provincia;

}
