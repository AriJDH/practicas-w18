package com.spring.calorias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calorias.dto.IngredienteDtoRes;
import com.spring.calorias.dto.PlatoDtoReq;
import com.spring.calorias.dto.PlatoDtoRes;
import com.spring.calorias.entity.Ingrediente;
import com.spring.calorias.entity.Plato;
import com.spring.calorias.repository.FoodRepository;
import com.spring.calorias.repository.IFoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService implements IFoodService{

    private IFoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public PlatoDtoRes getPlato(String nombre, int peso) {
        ObjectMapper op = new ObjectMapper();

        Plato plato = foodRepository.getPlato(nombre, peso);
        if(plato == null) return null;

        List<Ingrediente> ingredientes = plato.getIngredientes();
        List<IngredienteDtoRes> ingredienteDtoRes = ingredientes.stream()
                .map(i -> op.convertValue(i, IngredienteDtoRes.class))
                .collect(Collectors.toList());
        int totalCalorias = ingredientes.stream()
                .map(i -> i.getCalories())
                .mapToInt(Integer::intValue)
                .sum();
        Ingrediente masCalorico = ingredientes.stream()
                .reduce(new Ingrediente("water", Integer.MIN_VALUE), (a, b) -> a.getCalories() > b.getCalories() ? a : b);

        return new PlatoDtoRes(totalCalorias, ingredienteDtoRes, op.convertValue(masCalorico, IngredienteDtoRes.class));
    }

    @Override
    public List<PlatoDtoRes> getPlatos(List<PlatoDtoReq> platosDtoReq) {
        List<PlatoDtoRes> res = platosDtoReq.stream()
                .map(p -> getPlato(p.getName(), p.getGrams()))
                .collect(Collectors.toList());

        return res;
    }

    @Override
    public List<IngredienteDtoRes> getComidas() {
        ObjectMapper op = new ObjectMapper();

        List<Ingrediente> ingredientes = foodRepository.getComidas();
        List<IngredienteDtoRes> comidasDtoRes = ingredientes.stream()
                .map(c -> op.convertValue(c, IngredienteDtoRes.class))
                .collect(Collectors.toList());

        return comidasDtoRes;
    }

    @Override
    public List<IngredienteDtoRes> findComidas(String name) {
        ObjectMapper op = new ObjectMapper();

        List<Ingrediente> ingredientes = foodRepository.findComidas(name);
        List<IngredienteDtoRes> comidasDtoRes = ingredientes.stream()
                .map(c -> op.convertValue(c, IngredienteDtoRes.class))
                .collect(Collectors.toList());

        return comidasDtoRes;
    }
}
