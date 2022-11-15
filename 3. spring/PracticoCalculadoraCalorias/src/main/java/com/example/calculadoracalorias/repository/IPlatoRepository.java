package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Plato;

import java.util.List;

public interface IPlatoRepository {
    void generarMenu();
    void guardarPlato(Plato plato);
    List<Plato> mostrarPlatos();
}
