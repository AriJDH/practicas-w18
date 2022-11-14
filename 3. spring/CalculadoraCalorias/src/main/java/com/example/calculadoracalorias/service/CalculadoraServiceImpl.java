package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import com.example.calculadoracalorias.repository.CalculadoraRepositoryImpl;
import com.example.calculadoracalorias.repository.ICalculadoraRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService{

    private final ICalculadoraRepository repository;

    public CalculadoraServiceImpl(){
        this.repository = new CalculadoraRepositoryImpl();
    }

    @Override
    public HashMap<String, Object> getDatos(String nombrePlato) {

        List<Plato> platos = this.repository.findAllPlatos();
        Plato res = null;
        for(Plato p : platos){
            if(p.getNombre().equals(nombrePlato)) {
                res = p;
                break;
            }
            // si no se enceuntra aca hay a tirar una excepcion
        }



        int totalCalorias = 0;
        Ingrediente ingredienteMasCalorias = null;
        for (Ingrediente i : res.getIngredientes()){
            totalCalorias += i.getCalories();
            if(ingredienteMasCalorias == null || ingredienteMasCalorias.getCalories() < i.getCalories()){
                ingredienteMasCalorias = i;
            }
        }

        List<IngredienteDTO> ingredientesDto = new ArrayList<>();
        for(Ingrediente i : res.getIngredientes()){
            ingredientesDto.add(new IngredienteDTO(i.getName(), i.getCalories()));
        }

        HashMap<String, Object> mapa = new HashMap<>();
        mapa.put("ingredientes", ingredientesDto);
        mapa.put("totalCalorias", totalCalorias);
        mapa.put("ingredienteMasCalorias", ingredienteMasCalorias);


        return mapa;
    }

}
