package service;

import dto.FoodDTO;
import entity.Plato;
import entity.Food;

import dto.PlatoDTO;
import org.springframework.stereotype.Service;
import repository.IRepository;

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