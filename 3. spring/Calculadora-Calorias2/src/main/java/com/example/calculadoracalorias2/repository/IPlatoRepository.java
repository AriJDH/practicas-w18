package com.example.calculadoracalorias2.repository;

import com.example.calculadoracalorias2.entity.Ingrediente;
import com.example.calculadoracalorias2.entity.Plato;

import java.util.List;

public interface IPlatoRepository {

    Plato findOne(String nombre);
    double calcularTotalCalorias(String nombrePlato);

    List<Ingrediente> listaIngredientes(String nombrePlato);

     Ingrediente maxCalorias(String nombre);

};