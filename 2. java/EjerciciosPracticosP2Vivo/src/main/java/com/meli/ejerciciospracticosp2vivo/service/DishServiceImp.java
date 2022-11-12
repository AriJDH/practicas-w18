package com.meli.ejerciciospracticosp2vivo.service;

import com.meli.ejerciciospracticosp2vivo.dto.DishDTO;
import com.meli.ejerciciospracticosp2vivo.dto.DishResponseDTO;
import com.meli.ejerciciospracticosp2vivo.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImp implements IDishService {

    @Autowired
    IIngredientRepository iIngredientRepository;

    @Override
    public DishResponseDTO getTotalCalories(DishDTO dishDTO) {
        Double sum = 0d;
        for ( var ingredient : dishDTO.getIngredientList() ){
            var in = iIngredientRepository.getIngredientAll().stream().filter( i -> i.getName().equals(ingredient.getName())).findFirst().orElse(null);
            if (in == null) continue;
            System.out.println();
            sum+= ( ingredient.getWeight() * in.getCalories());
        }
        return new DishResponseDTO(
                dishDTO.getName(),
                sum
        );
    }
}
