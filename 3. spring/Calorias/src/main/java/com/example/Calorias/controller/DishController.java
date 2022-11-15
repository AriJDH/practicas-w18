package com.example.Calorias.controller;

import com.example.Calorias.dto.response.DishDTO;
import com.example.Calorias.service.DishServiceImp;
import com.example.Calorias.service.IDishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {
    private IDishService dishService;

    public DishController(DishServiceImp dishServiceImp) {
        this.dishService = dishServiceImp;
    }

    @GetMapping("/{name}")
    public ResponseEntity<DishDTO> findDishByName(@PathVariable String name){
        return new ResponseEntity<>(dishService.findDishByName(name), HttpStatus.OK);
    }
}
