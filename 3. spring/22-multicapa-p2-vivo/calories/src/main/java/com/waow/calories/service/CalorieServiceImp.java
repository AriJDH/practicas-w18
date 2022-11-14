package com.waow.calories.service;

import com.waow.calories.dto.request.PlateDTOReq;
import com.waow.calories.dto.response.PlateDTORes;
import com.waow.calories.entity.Ingredient;
import com.waow.calories.entity.Plate;
import com.waow.calories.repository.IIngredientRepository;
import com.waow.calories.repository.IPlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalorieServiceImp implements ICalorieService {

    @Autowired
    private IPlateRepository plateRepository;

    @Override
    public PlateDTORes getPlateInfoByNameGrams(String plateName, int plateGrams) {
        return new PlateDTORes(
                getCaloriesTotal(plateName, plateGrams),
                getPlateIngredientCaloriesMap(plateName, plateGrams),
                getMaxCalorieIngredient(plateName).getName());
    }

    @Override
    public List<PlateDTORes> getPlatesInfoByDTO(PlateDTOReq plateDTOReq) {
        return plateDTOReq.getPlateNameGramsMapList().stream()
                .map(plateNameGramsMap -> getPlateInfoByNameGrams(
                        plateNameGramsMap.get("name"),
                        Integer.parseInt(plateNameGramsMap.get("grams"))))
                .collect(Collectors.toList());
    }

    private double getCaloriesTotal(String plateName, int plateGrams) {
        Plate plate = plateRepository.findPlateByName(plateName).orElseThrow();
        return plate.getIngredientGramsMap().entrySet().stream()
                // calories per ingredient
                .mapToDouble(ingredientGramsEntry ->
                        ingredientGramsEntry.getKey().getCaloriesPer100Grams()
                        * ingredientGramsEntry.getValue() / 100.)
                // return calories of plate proportional to base plate grams
                .sum() * plateGrams / plate.getBasePlateGrams();
    }

    private Map<String, Double> getPlateIngredientCaloriesMap(String plateName, int plateGrams) {
        Plate plate = plateRepository.findPlateByName(plateName).orElseThrow();
        return plate.getIngredientGramsMap().entrySet().stream()
                .collect(Collectors.toMap(
                        ingredientGramsEntry -> ingredientGramsEntry.getKey().getName(),
                        ingredientGramsEntry -> ingredientGramsEntry.getKey().getCaloriesPer100Grams()
                                * ingredientGramsEntry.getValue()
                                * plateGrams / plate.getBasePlateGrams() / 100.));
    }

    private Ingredient getMaxCalorieIngredient(String plateName) {
        return plateRepository.findPlateByName(plateName).orElseThrow()
                .getIngredientGramsMap().entrySet().stream()
                // get max by comparing (ingredient calories * grams) between all ingredients
                .max(Comparator.comparing(i -> i.getKey().getCaloriesPer100Grams() * i.getValue()))
                .orElseThrow().getKey();
    }
}
