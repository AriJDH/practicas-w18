package com.ejerciciospring.ejercicios_spring.calculadora_calorias.service;

import com.ejerciciospring.ejercicios_spring.calculadora_calorias.dto.FoodDTO;
import com.ejerciciospring.ejercicios_spring.calculadora_calorias.dto.PlatoDTO;
import com.ejerciciospring.ejercicios_spring.calculadora_calorias.entity.Food;
import com.ejerciciospring.ejercicios_spring.calculadora_calorias.entity.Plato;
import com.ejerciciospring.ejercicios_spring.calculadora_calorias.repository.IRepository;
import com.ejerciciospring.ejercicios_spring.calculadora_calorias.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePlatoImpl implements IServicePlato {

    private IRepository platoRepository;

    public ServicePlatoImpl(IRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public PlatoDTO consultarPlato(String nombre, Integer peso) {

        Plato plato = platoRepository.consultarPlato(nombre, peso);

        if (plato == null) {
            return new PlatoDTO(null, null, null, "No existe el plato");
        }

        List<FoodDTO> foodDTOs = new ArrayList<>();

        String nombreMayorCaloria = "";
        Integer mayorCaloria = 0;

        for (Food food : plato.getFoods()) {
            FoodDTO foodDTO = new FoodDTO(food.getName(), food.getCalories());
            foodDTOs.add(foodDTO);

            if (food.getCalories() > mayorCaloria) {
                nombreMayorCaloria = food.getName();
                mayorCaloria = food.getCalories();
            }

        }

        return new PlatoDTO(plato.getPesoGramo(), foodDTOs, nombreMayorCaloria, "Existe");
    }
}
