package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.response.DishDTOres;
import com.example.calculadoracalorias.service.DishService;
import com.example.calculadoracalorias.service.IDishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {

    private final IDishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @GetMapping("/{name}/{weight}")
    public ResponseEntity<?> findDishCaloriesByNameAndWeight(
            @PathVariable String name,
            @PathVariable Double weight){

        DishDTOres dish = service.getDishByNameAndWeight(name);

        return null;
    }


    @PostMapping("/addDish")
    public ResponseEntity<?> addDish(String name, Double weight){
        return null;
    }







}
