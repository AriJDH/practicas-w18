package com.bootcamp.testing.controller;

import com.bootcamp.testing.dto.request.RecipeDTO;
import com.bootcamp.testing.dto.response.DishResponseDTO;
import com.bootcamp.testing.service.IKitchenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    IKitchenService kitchenService;

    public MenuController ( IKitchenService kitchenService ) {
        this.kitchenService = kitchenService;
    }

    @PostMapping("/dish")
    public DishResponseDTO createDish( @RequestParam String name){
        return kitchenService.createDish(name);
    }

}