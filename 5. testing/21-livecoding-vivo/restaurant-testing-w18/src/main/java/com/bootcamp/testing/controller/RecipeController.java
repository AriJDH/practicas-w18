package com.bootcamp.testing.controller;

import com.bootcamp.testing.dto.request.RecipeDTO;
import com.bootcamp.testing.service.IKitchenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    IKitchenService kitchenService;

    public RecipeController ( IKitchenService kitchenService ) {
        this.kitchenService = kitchenService;
    }

    @GetMapping("/list")
    public List<RecipeDTO> listRecipes(){
        return kitchenService.getRecipes();
    }

    @PostMapping("/recipe")
    public RecipeDTO createRecipe(@RequestBody RecipeDTO recipeDTO){
        return kitchenService.createRecipe(recipeDTO);
    }
}
