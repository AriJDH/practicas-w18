package com.example.pedidoderopa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
public class Pedido {

    private int numero;
    private List<Ropa> ropas;
}
