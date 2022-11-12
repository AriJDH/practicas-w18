package com.meli.ejerciciospracticosp2vivo.controller;

import com.meli.ejerciciospracticosp2vivo.dto.DishDTO;
import com.meli.ejerciciospracticosp2vivo.dto.DishResponseDTO;
import com.meli.ejerciciospracticosp2vivo.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {

    @Autowired
    private IDishService iDishService;

    @PostMapping("/dish/totalCalories")
    public ResponseEntity<DishResponseDTO> getTotalCalories(@RequestBody DishDTO dish) {
        System.out.println(dish);
        return new ResponseEntity<>(iDishService.getTotalCalories(dish), HttpStatus.OK);
    }
}
