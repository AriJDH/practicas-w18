package com.example.empresa_elasticsearch.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreacionEmpleadoDTO {

    private String id;

    private String nombre;

    private String apellido;

    private Integer edad;

    private String ciudad;

    private String nombreUnico;
}
