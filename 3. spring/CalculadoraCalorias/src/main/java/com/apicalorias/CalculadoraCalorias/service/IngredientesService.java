package com.apicalorias.CalculadoraCalorias.service;

import com.apicalorias.CalculadoraCalorias.dto.IngredienteDTO;
import com.apicalorias.CalculadoraCalorias.dto.IngredientesConCantidadesDTO;
import com.apicalorias.CalculadoraCalorias.dto.PlatoConCantidadesDTO;
import com.apicalorias.CalculadoraCalorias.dto.PlatoRequestDTO;
import com.apicalorias.CalculadoraCalorias.entity.Ingrediente;
import com.apicalorias.CalculadoraCalorias.repository.IIngredientesRepository;
import com.apicalorias.CalculadoraCalorias.repository.IngredientesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientesService implements IIngredientesService{

    IIngredientesRepository ingredientesRepository;

    public IngredientesService(IngredientesRepository ingredientesRepository){
        this.ingredientesRepository=ingredientesRepository;
        ingredientesDTO();
    }

    //Cambiar a DTO
    @Override
    public List<IngredienteDTO> ingredientesDTO() {
        List<Ingrediente> ingredientes = ingredientesRepository.retornarListaIngredientes();
        ObjectMapper op=new ObjectMapper();
        List<IngredienteDTO> ingredientesDTO = ingredientes.stream().map(p-> op.convertValue(p,IngredienteDTO.class)).collect(Collectors.toList());

        return ingredientesDTO;
    }

    //Calcula las calorias del plato (int) multiplicando por la cantidad
    @Override
    public Integer caloriasDOS(PlatoConCantidadesDTO platoAConsultar) {
        Integer calorias = 0;
        List<IngredientesConCantidadesDTO> ingredientesCantidad = platoAConsultar.getIngredientes();
        for (IngredienteDTO ingred : ingredientesDTO()) {
            for (IngredientesConCantidadesDTO ingreCan : ingredientesCantidad) {
                if (ingreCan.getName().equals(ingred.getName())) {
                    calorias += ingred.getCalories() * ingreCan.getCantidad();
                }
            }
        }
        return calorias;
        }

    //Calcula las calorias del plato(int) sin multiplicar
    @Override
    public Integer calorias(PlatoRequestDTO platoAConsultar){
        Integer calorias=0;
        for(IngredienteDTO ingred : ingredientesDTO()){
            if(platoAConsultar.getIngredientes().contains(ingred.getName())){

                calorias+= ingred.getCalories();
            }
        }
        return calorias;
    }

    //Dar los ingredientes de un plato
    @Override
    public List<IngredienteDTO> decirIngredientes(PlatoRequestDTO platoAConsultar){
        List<IngredienteDTO> parteDelPlato = new ArrayList<>();
        for(IngredienteDTO ingred : ingredientesDTO()){
            if(platoAConsultar.getIngredientes().contains(ingred.getName())){
                parteDelPlato.add(ingred);
            }
        }
        return parteDelPlato;
    }

    //Dar los ingredientes de un plato
    @Override
    public IngredienteDTO decirMayorCalorias(PlatoRequestDTO platoAConsultar){
        IngredienteDTO masCalorias=new IngredienteDTO();
        Integer maxcalo=0;

        for(IngredienteDTO ingred : ingredientesDTO()){
            if(platoAConsultar.getIngredientes().contains(ingred.getName())){
                if (ingred.getCalories()> maxcalo){
                    maxcalo=ingred.getCalories();
                    masCalorias = ingred;
                }
            }
        }
        return masCalorias;
    }


}
