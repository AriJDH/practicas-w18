package com.example.productos.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponse {

    private String nombre;

    private String tipo;

    private Double precioVenta;

    private Double precioCosto;

    private Double cantidadDisponible;

}
