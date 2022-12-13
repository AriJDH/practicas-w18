package com.example.productos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Integer cantidadDisponible;
}