package com.example.CalculadoraDeIngredientes.service;

import com.example.CalculadoraDeIngredientes.dto.PlatoDto;
import com.example.CalculadoraDeIngredientes.entity.Plato;

import java.util.List;

public interface IPlatosService {

    public List<PlatoDto> getAll();
}
