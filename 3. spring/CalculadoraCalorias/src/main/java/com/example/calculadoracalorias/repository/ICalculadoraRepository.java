package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ICalculadoraRepository {

    public List<Ingrediente> findAllIngredientes();
    public List<Plato> findAllPlatos();
}
