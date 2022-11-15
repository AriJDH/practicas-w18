package com.apicalorias.CalculadoraCalorias.controller;

import com.apicalorias.CalculadoraCalorias.dto.IngredienteDTO;
import com.apicalorias.CalculadoraCalorias.dto.PlatoConCantidadesDTO;
import com.apicalorias.CalculadoraCalorias.dto.PlatoRequestDTO;
import com.apicalorias.CalculadoraCalorias.service.IIngredientesService;
import com.apicalorias.CalculadoraCalorias.service.IngredientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    IIngredientesService ingredientesService;

    public Controller(IngredientesService ingredientesService){
        this.ingredientesService=ingredientesService;
    }

    //Da las calorias totales multiplicadas por la cantidad como int (como si 1g de ese ingrediente tuviera las calorias que da el DS)
    //Por ejemplo se le pasa {"nombre": "Ensalada", "ingredientes": [{"name": "Calabaza", "cantidad": 2},{"name": "Cebolla", "cantidad": 3}]}
    @PostMapping("/caloriasdos")
    public Integer caloriasCaldos(@RequestBody PlatoConCantidadesDTO platoRequestDTO){
        return ingredientesService.caloriasDOS(platoRequestDTO);
    }

    //Da las calorias del plato sin contar la cantidad
    @PostMapping("/calorias")
    public Integer caloriasCal(@RequestBody PlatoRequestDTO platoRequestDTO){
        return ingredientesService.calorias(platoRequestDTO);
    }


    //Da los ingredientes del plato y sus calorias individuales
    @PostMapping("/ingredientes")
    public List<IngredienteDTO> decirIng(@RequestBody PlatoRequestDTO platoRequestDTO){
        return ingredientesService.decirIngredientes(platoRequestDTO);
    }

    //Retorna el ingrediente con más calorias (individual)
    @PostMapping("/mayorcalorias")
    public IngredienteDTO decirMayorCalo(@RequestBody PlatoRequestDTO platoRequestDTO){
        return ingredientesService.decirMayorCalorias(platoRequestDTO);
    }

}
