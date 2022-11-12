package com.meli.ejerciciospracticosp2vivo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ejerciciospracticosp2vivo.dto.IngredientDTO;
import com.meli.ejerciciospracticosp2vivo.entity.Ingredient;
import com.meli.ejerciciospracticosp2vivo.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class IngredientServiceImp implements IIngredientService {

    private ObjectMapper op = new ObjectMapper();

    @Autowired
    private IIngredientRepository iIngredientRepository;

    @Override
    public IngredientDTO getMaxCaloriesIngredient() {
        var ingredient = iIngredientRepository.getIngredientAll().stream().
                max(Comparator.comparing(Ingredient::getCalories)).orElse(null);
        if (ingredient == null) return null;
        return op.convertValue(ingredient,IngredientDTO.class);
    }
}
