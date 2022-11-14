package com.example.CalculadoraDeCalorias.services;

import com.example.CalculadoraDeCalorias.dto.in.IngredienteDtoIn;
import com.example.CalculadoraDeCalorias.dto.in.PlatoDtoIn;
import com.example.CalculadoraDeCalorias.dto.out.IngredienteDtoOut;
import com.example.CalculadoraDeCalorias.dto.out.PlatoDtoOut;
import com.example.CalculadoraDeCalorias.entity.Ingrediente;
import com.example.CalculadoraDeCalorias.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CalculadoraServiceImp implements ICalculadoraService{

    @Autowired
    IIngredienteRepository repository;

    @Override
    public List<PlatoDtoOut> platoFinal(List<PlatoDtoIn> platoList) {
        List<PlatoDtoOut> lista = null;

        for(PlatoDtoIn platoDtoIn : platoList) {
            PlatoDtoOut platoDtoOut = new PlatoDtoOut();
            platoDtoOut.setIngredientes(listaConCalorias(platoDtoIn.getIngredienteList()));
            platoDtoOut.setTotalCalorias(caloriasTotales(platoDtoIn.getIngredienteList()));

            IngredienteDtoOut masCalorico = null;
            Double caloria = 0.0;

            for (IngredienteDtoOut ingredienteDtoOut : listaConCalorias(platoDtoIn.getIngredienteList())) {
                if (ingredienteDtoOut.getCalorias() > caloria) {
                    masCalorico = ingredienteDtoOut;
                }
            }

            platoDtoOut.setIngredienteMasCalorico(masCalorico);

            lista.add(platoDtoOut);
        }

        return lista;
    }





    private Integer caloriasTotales(List<IngredienteDtoIn> listaIngredientes){
        Integer calorias = 0;

        for (IngredienteDtoIn ingrediente : listaIngredientes){
            Ingrediente temp = repository.findByName(ingrediente.getNombre());
            if(temp != null){
                calorias += temp.getCalories() * ingrediente.getPeso() / 100;
            }
        }
        return calorias;
    }

    private List<IngredienteDtoOut> listaConCalorias(List<IngredienteDtoIn> ingredienteList){
        List<IngredienteDtoOut> list = null;

        for (IngredienteDtoIn ingrediente : ingredienteList){
            Ingrediente temp = repository.findByName(ingrediente.getNombre());
            if(temp != null){
                IngredienteDtoOut ingredienteDtoOut = new IngredienteDtoOut();
                ingredienteDtoOut.setNombre(temp.getName());
                ingredienteDtoOut.setCalorias(temp.getCalories() * ingrediente.getPeso() / 100);
                list.add(ingredienteDtoOut);
            }
        }

        return list;
    }
}
