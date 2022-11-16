package com.example.calculadora.service.impl;

import com.example.calculadora.dto.req.PlateDTOReq;
import com.example.calculadora.dto.res.PlateDTORes;
import com.example.calculadora.entity.Ingredient;
import com.example.calculadora.entity.Plate;
import com.example.calculadora.repository.IPlateRepository;
import com.example.calculadora.repository.impl.PlateRepository;
import com.example.calculadora.service.IPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PlateService implements IPlateService {

    private IPlateRepository plateRepository;

    @Autowired
    public PlateService(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public PlateDTORes getData(PlateDTOReq plateDto) {
        PlateDTORes dto = new PlateDTORes();
        Plate plate = findByName(plateDto.getName());
        dto.setCalories(sumCalories(plate)*(plateDto.getWeight()/1000));
        dto.setIngredients(findIngredientAndCalories(plate));
        dto.setMaxCalorieIngredient(maxCalories(plate));
        return dto;
    }

    @Override
    public Double sumCalories(Plate plate) {
        return plate.getIngredients().stream().mapToDouble(Ingredient::getCalories).sum();
    }

    @Override
    public List<Ingredient> findIngredientAndCalories(Plate plate) {
        return plate.getIngredients();
    }

    @Override
    public Double maxCalories(Plate plate) {
        return plate.getIngredients().stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .get().getCalories();
    }

    @Override
    public Plate findByName(String name) {
        return plateRepository.findAll().stream()
                .filter(dish -> dish.getName().equals(name))
                .findFirst()
                .get();
    }
}
