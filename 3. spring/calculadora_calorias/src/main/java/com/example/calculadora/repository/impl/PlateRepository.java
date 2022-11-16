package com.example.calculadora.repository.impl;

import com.example.calculadora.entity.Ingredient;
import com.example.calculadora.entity.Plate;
import com.example.calculadora.repository.IPlateRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlateRepository implements IPlateRepository {

    List<Plate> plates = new ArrayList<>();
    Ingredient cheese = new Ingredient("Cheese",700.);
    Ingredient onion = new Ingredient("Onion",7.);
    Ingredient pepperoni = new Ingredient("Pepperoni",1002.);
    Ingredient bacon = new Ingredient("Bacon",1200.);
    Ingredient egg = new Ingredient("Egg",600.);

    List<Ingredient>iF = new ArrayList<>();
    List<Ingredient>iP = new ArrayList<>();
    List<Ingredient>iB = new ArrayList<>();
    List<Ingredient>iE = new ArrayList<>();

    public PlateRepository() {
        create();
    }

    @Override
    public void create() {
        iF.add(cheese);
        iF.add(onion);
        plates.add(new Plate("Fugazeta",iF));
        iP.add(cheese);
        iP.add(pepperoni);
        plates.add(new Plate("Pepperoni",iP));
        iB.add(cheese);
        iB.add(bacon);
        plates.add(new Plate("Bacon",iB));
        iE.add(cheese);
        iE.add(egg);
        plates.add(new Plate("Egg",iE));
    }

    @Override
    public List<Plate> findAll() {
        return plates;
    }
}
