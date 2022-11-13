package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.entity.Dish;
import com.bootcamp.calculadoraCalorias.entity.Ingredient;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class DishRepositoryImp implements IDishRepository {

    List<Dish>dishes=new ArrayList<>();
    Ingredient cheese=new Ingredient("Cheese",700.);
    Ingredient pepper=new Ingredient("Pepper",12.2);
    Ingredient onion=new Ingredient("Onion",7.);
    Ingredient pepperoni=new Ingredient("Pepperoni",1002.);
    Ingredient bacon=new Ingredient("Bacon",1200.);
    Ingredient egg=new Ingredient("Egg",600.);

    List<Ingredient>iF=new ArrayList<>();
    List<Ingredient>iP=new ArrayList<>();
    List<Ingredient>iB=new ArrayList<>();
    List<Ingredient>iE=new ArrayList<>();

    public DishRepositoryImp() {
        create();
    }

    @Override
    public void create() {
        iF.add(cheese);
        iF.add(onion);
        dishes.add(new Dish("Fugazeta",iF));
        iP.add(cheese);
        iP.add(pepperoni);
        dishes.add(new Dish("Pepperoni",iP));
        iB.add(cheese);
        iB.add(bacon);
        dishes.add(new Dish("Bacon",iB));
        iE.add(cheese);
        iE.add(egg);
        dishes.add(new Dish("Egg",iE));
    }

    @Override
    public List<Dish> findAll() {
        return dishes;
    }
}
