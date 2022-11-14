package com.ejerciciospring.ejercicios_spring.calculadora_calorias.repository;

import com.ejerciciospring.ejercicios_spring.calculadora_calorias.entity.Plato;

import java.util.List;

public interface IRepository {

        Plato consultarPlato(String nombre, Integer peso);
}
