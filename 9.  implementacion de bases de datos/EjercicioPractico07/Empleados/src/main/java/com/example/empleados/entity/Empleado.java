package com.example.empleados.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "empleados")
public class Empleado {

    @Id
    private String id;

    private String nombre;

    private String apellido;

    private Integer edad;

    private String ciudad;

    private String provincia;

}
