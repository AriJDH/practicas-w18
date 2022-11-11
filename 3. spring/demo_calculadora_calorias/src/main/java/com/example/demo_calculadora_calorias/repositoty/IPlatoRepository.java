package com.example.demo_calculadora_calorias.repositoty;

import com.example.demo_calculadora_calorias.entity.Plato;

import java.util.List;

public interface IPlatoRepository {
    List<Plato> findAll();
    void loadList();
}
