package com.example.calorias.repository;

import com.example.calorias.entity.Plato;

import java.util.List;

public interface IPlatoRepository {

    public List<Plato>findAll();
    public void cargarLista();

}
