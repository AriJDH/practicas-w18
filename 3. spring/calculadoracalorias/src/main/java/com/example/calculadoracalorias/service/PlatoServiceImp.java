package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.FoodDto;
import com.example.calculadoracalorias.dto.PlatoDto;
import com.example.calculadoracalorias.entity.Food;
import com.example.calculadoracalorias.entity.Plato;
import com.example.calculadoracalorias.repository.IPlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoServiceImp implements IPlatoService{

    private IPlatoRepository platoRepository;

    public PlatoServiceImp(IPlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public PlatoDto consultarPlato(String nombre, Integer peso) {

        Plato plato = platoRepository.consultarPlato(nombre, peso);

        if (plato == null) {
            return new PlatoDto(null, null, null, "No existe el plato");
        }

        List<FoodDto> foodDTOs = new ArrayList<>();

        String nombreMayorCaloria = "";
        Integer mayorCaloria = 0;

        for (Food food : plato.getFoods()) {
            FoodDto foodDTO = new FoodDto(food.getName(), food.getCalories());
            foodDTOs.add(foodDTO);

            if (food.getCalories() > mayorCaloria) {
                nombreMayorCaloria = food.getName();
                mayorCaloria = food.getCalories();
            }
        }

        return new PlatoDto(plato.getPesoGramo(), foodDTOs, nombreMayorCaloria, "Existe");
    }
}
