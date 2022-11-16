package com.example.calculadora.service;

import com.example.calculadora.dto.req.PlateDTOReq;
import com.example.calculadora.dto.res.PlateDTORes;
import com.example.calculadora.entity.Ingredient;
import com.example.calculadora.entity.Plate;

import java.util.List;

public interface IPlateService {

    PlateDTORes getData(PlateDTOReq plateDto);
    Double sumCalories(Plate plate);
    List<Ingredient> findIngredientAndCalories(Plate plate);
    Double maxCalories(Plate plate);
    Plate findByName(String name);
}
