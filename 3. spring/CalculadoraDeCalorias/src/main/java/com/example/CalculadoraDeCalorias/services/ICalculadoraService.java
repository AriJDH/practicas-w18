package com.example.CalculadoraDeCalorias.services;

import com.example.CalculadoraDeCalorias.dto.in.IngredienteDtoIn;
import com.example.CalculadoraDeCalorias.dto.in.PlatoDtoIn;
import com.example.CalculadoraDeCalorias.dto.out.PlatoDtoOut;
import com.example.CalculadoraDeCalorias.entity.Ingrediente;

import java.util.List;

public interface ICalculadoraService {

    List<PlatoDtoOut> platoFinal(List<PlatoDtoIn> platoList);

}
