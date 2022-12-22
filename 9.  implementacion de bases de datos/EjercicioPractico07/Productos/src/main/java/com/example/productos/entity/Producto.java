package com.example.productos.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "productos")
public class Producto {

    @Id
    private String id;

    private String nombre;

    private String tipo;

    private Double precioVenta;

    private Double precioCosto;

    private Double cantidadDisponible;

}
