package com.meli.ejerciciospracticosp2vivo.controller;

import com.meli.ejerciciospracticosp2vivo.dto.IngredientDTO;
import com.meli.ejerciciospracticosp2vivo.service.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {

    @Autowired
    private IIngredientService ingredientService;

    @GetMapping("/ingredient/maxCalories")
    public ResponseEntity<IngredientDTO> getTotalCalories() {
        return new ResponseEntity<>(ingredientService.getMaxCaloriesIngredient(), HttpStatus.OK);
    }
}
