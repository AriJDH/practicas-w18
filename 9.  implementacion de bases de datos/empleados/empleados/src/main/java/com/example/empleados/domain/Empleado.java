package com.example.empleados.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "blog")
public class Empleado {
    @Id
    private Long id;

    private String nombre;
    private String apellido;
    private int edad;
    //deberia ser otra clase?
    private String ciudad;
    private String provincia;
}
