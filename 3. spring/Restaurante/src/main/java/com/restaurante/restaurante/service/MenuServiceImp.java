package com.restaurante.restaurante.service;

import com.restaurante.restaurante.dto.PlatoDto;
import com.restaurante.restaurante.entity.Ingrediente;
import com.restaurante.restaurante.entity.Plato;
import com.restaurante.restaurante.repository.ImenuRepository;
import com.restaurante.restaurante.repository.MenuRepositoryImp;

import java.util.List;

public class MenuServiceImp implements ImenuService{
//angel benjamin fernandez y migue
    ImenuRepository repo = new MenuRepositoryImp();
    @Override
    public Double getTotalCalorias(PlatoDto plato) {
        Integer rdo = 0;
        Plato p = new Plato();
        p = platoByName(plato.getNombre());
        for(Ingrediente i: p.getIngredientes())
            rdo += i.getCalories();
        return rdo*plato.getPeso();
    }

    @Override
    public Ingrediente getMayorCaloria(PlatoDto plato) {
        Ingrediente ingrediente = new Ingrediente();
        Integer max = 0;
        Plato p = new Plato();
        p = platoByName(plato.getNombre());
        for(Ingrediente i: p.getIngredientes()){
            if(i.getCalories()>max){
                max= i.getCalories();
                ingrediente = i;
            }
        }
        return ingrediente;
    }

    @Override
    public List<Ingrediente> getAllIngredientes(PlatoDto plato) {
        Plato p = new Plato();
        p = platoByName(plato.getNombre());
        return p.getIngredientes();
    }

    public Plato platoByName(String name){
        Plato plato = new Plato();
        for(Plato p: repo.getAll()){
            if(p.getNombre().equals(name))
                plato=p;
        }
        return plato;
    }
}
