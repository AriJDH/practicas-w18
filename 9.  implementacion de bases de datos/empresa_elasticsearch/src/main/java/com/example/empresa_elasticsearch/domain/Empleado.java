package com.example.empresa_elasticsearch.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "empresa")
@Setter
@Getter
public class Empleado {

    @Id
    private String id;

    private String nombre;

    private String apellido;

    private Integer edad;

    private String ciudad;

    @Field(type = FieldType.Keyword)
    private String nombreUnico;

}
