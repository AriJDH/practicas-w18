package com.example.productos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

    private String nombre;

    private String tipo;

    private Double precioVenta;

    private Double precioCosto;

    private Double cantidadDisponible;

}
