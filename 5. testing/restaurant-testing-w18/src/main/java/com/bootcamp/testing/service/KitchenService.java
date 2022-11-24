package com.bootcamp.testing.service;

import com.bootcamp.testing.dto.request.RecipeDTO;
import com.bootcamp.testing.dto.response.DishResponseDTO;
import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.model.Recipe;
import com.bootcamp.testing.exception.notfound.IngredientNotFoundException;
import com.bootcamp.testing.exception.notfound.RecipeNotFoundException;
import com.bootcamp.testing.repository.interfaces.IRecipeRepository;
import com.bootcamp.testing.repository.interfaces.IStorehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KitchenService implements IKitchenService {
    IRecipeRepository     recipeRepository;
    IStorehouseRepository storehouseRepository;

    ModelMapper mapper;

    public KitchenService ( IRecipeRepository recipeRepository, IStorehouseRepository storehouseRepository ) {
        this.recipeRepository     = recipeRepository;
        this.storehouseRepository = storehouseRepository;
        mapper                    = new ModelMapper();
    }

    /* DISHES */
    @Override
    public DishResponseDTO createDish ( String name ) {

        Recipe recipe = getRecipe(name);

        this.updateIngredientsOf(recipe);

        Double quality = this.getQualityOf(recipe);

        Double calories = this.getTotalCaloriesOf(recipe);

        DishResponseDTO recipeDTO = mapper.map(recipe, DishResponseDTO.class);
        recipeDTO.setQuality(quality);
        recipeDTO.setCalories(calories);

        return recipeDTO;
    }

    /* RECIPES */
    @Override
    public List<RecipeDTO> getRecipes () {
        return recipeRepository.getRecipes()
          .stream()
          .map(recipe -> mapper.map(recipe, RecipeDTO.class))
          .collect(Collectors.toList());
    }

    @Override
    public Recipe getRecipe ( String name ) {
        Optional<Recipe> optionalRecipe = recipeRepository.getRecipe(name);
        Recipe        recipe         = optionalRecipe.orElseThrow(() -> new RecipeNotFoundException(name));
        return recipe;
    }

    @Override
    public RecipeDTO createRecipe ( RecipeDTO recipedto ) {
        Recipe recipe = mapper.map(recipedto, Recipe.class);
        Recipe createdRecipe = recipeRepository.createRecipe(recipe);
        return mapper.map(createdRecipe, RecipeDTO.class);
    }

    private void updateIngredientsOf ( Recipe recipe ) {
        List<Ingredient> ingredients = recipe.getIngredients()
          .stream()
          .map(ing -> {
                String               name               = ing.getName();
                Optional<Ingredient> optionalIngredient = storehouseRepository.getIngredient(name);
                Ingredient           ingredient         = optionalIngredient.orElseThrow(() -> new IngredientNotFoundException(name));
                ingredient.setQuantity(ing.getQuantity());
                return ingredient;
            }
          )
          .collect(Collectors.toList());

        recipe.setIngredients(ingredients);
    }


    private double getTotalCaloriesOf ( Recipe recipe ) {
        Double           totalCalories = 0D;
        List<Ingredient> ingredients   = recipe.getIngredients();

        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient ingredient = ingredients.get(i);
            totalCalories += ingredient.calcTotalCalories();
        }

        return totalCalories;
        /*
            return recipe.getIngredients()
              .stream()
              .mapToDouble(Ingredient::calcTotalCalories)
              .sum();
        */
    }

    private double getQualityOf ( Recipe recipe ) {
        Double           totalQuality = 0D;
        List<Ingredient> ingredients  = recipe.getIngredients();

        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient ingredient = ingredients.get(i);
            totalQuality += ingredient.getQuality();
        }

        if (!totalQuality.equals(0D)) {
            totalQuality = totalQuality / ingredients.size();
        }

        return totalQuality;
        /*
            return recipe.getIngredients()
              .stream()
              .mapToDouble(Ingredient::getQuality)
              .average()
              .orElse(0D);
        */
    }

}
