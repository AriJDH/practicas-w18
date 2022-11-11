package com.example.calculadoradecalorias.repository;

import com.example.calculadoradecalorias.entity.Ingredient;
import com.example.calculadoradecalorias.entity.Plate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlateRepositoryImp implements IPlateRepository{

    private List<Plate> platos;

    public PlateRepositoryImp() {
        this.platos = new ArrayList<>();
    }

    @Override
    public List<Plate> findAll() {
        return null;
    }

    @Override
    public List<Ingredient> showIngredients(String name, Double weight) {
        return null;
    }
}
