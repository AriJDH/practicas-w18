package com.spring.calorias.repository;

import com.spring.calorias.entity.Ingrediente;
import com.spring.calorias.entity.Plato;

import java.util.List;

public interface IFoodRepository {
    Plato getPlato(String nombre, int peso);
    List<Plato> getPlatos(List<String> nombres);
    List<Ingrediente> getComidas();
    List<Ingrediente> findComidas(String name);
}
