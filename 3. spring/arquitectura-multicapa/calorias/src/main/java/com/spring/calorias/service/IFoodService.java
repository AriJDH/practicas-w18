package com.spring.calorias.service;

import com.spring.calorias.dto.IngredienteDtoRes;
import com.spring.calorias.dto.PlatoDtoReq;
import com.spring.calorias.dto.PlatoDtoRes;
import com.spring.calorias.entity.Ingrediente;
import com.spring.calorias.entity.Plato;

import java.util.List;

public interface IFoodService {
    PlatoDtoRes getPlato(String nombre, int peso);
    List<PlatoDtoRes> getPlatos(List<PlatoDtoReq> platos);
    List<IngredienteDtoRes> getComidas();
    List<IngredienteDtoRes> findComidas(String name);
}
