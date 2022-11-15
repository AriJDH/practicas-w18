package com.mercadolibre.concesionariaautos.repository;

import com.mercadolibre.concesionariaautos.entity.Auto;

import java.util.List;

public interface IAutoRepository {
    void agregarAuto(Auto auto);
    List<Auto> mostrarListaAutos();
}
