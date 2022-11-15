package com.apicalorias.CalculadoraCalorias.service;

import com.apicalorias.CalculadoraCalorias.dto.IngredienteDTO;
import com.apicalorias.CalculadoraCalorias.dto.PlatoConCantidadesDTO;
import com.apicalorias.CalculadoraCalorias.dto.PlatoRequestDTO;

import java.util.List;

public interface IIngredientesService {
    public List<IngredienteDTO> ingredientesDTO();
    public Integer calorias(PlatoRequestDTO platoAConsultar);
    public List<IngredienteDTO> decirIngredientes(PlatoRequestDTO platoAConsultar);
    public IngredienteDTO decirMayorCalorias(PlatoRequestDTO platoAConsultar);

    public Integer caloriasDOS(PlatoConCantidadesDTO platoAConsultar);
}
