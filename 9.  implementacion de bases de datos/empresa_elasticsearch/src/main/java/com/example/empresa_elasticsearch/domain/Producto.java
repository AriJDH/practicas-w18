package com.example.empresa_elasticsearch.domain;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empresa")
@Setter
public class Producto {

    @Id
    private String id;

    String nombre;
}
