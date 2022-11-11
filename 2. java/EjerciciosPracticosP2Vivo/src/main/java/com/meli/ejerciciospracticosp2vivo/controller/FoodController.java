package com.meli.ejerciciospracticosp2vivo.controller;

import com.meli.ejerciciospracticosp2vivo.dto.FoodDTO;
import com.meli.ejerciciospracticosp2vivo.service.FoodServiceImp;
import com.meli.ejerciciospracticosp2vivo.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private IFoodService foodService = new FoodServiceImp();

    @GetMapping
    public List<FoodDTO> getFoodList(){
        return foodService.getFoodAll();
    }
}
