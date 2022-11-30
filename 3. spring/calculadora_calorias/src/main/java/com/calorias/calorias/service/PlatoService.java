package com.calorias.calorias.service;

import com.calorias.calorias.dto.ResponsePlatoDTO;
import com.calorias.calorias.entity.Ingrediente;
import com.calorias.calorias.entity.Plato;
import com.calorias.calorias.repository.RepositoryPlatos;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class PlatoService {

    RepositoryPlatos repositoryPlatos;

    public PlatoService() throws IOException {
        this.repositoryPlatos = new RepositoryPlatos();
    }

    public ResponsePlatoDTO getPlato(Integer idPlato){
          Plato plato =  repositoryPlatos.getPlatoById(idPlato);

          //calcular calorias totales
        double caloriasTotales = plato.getIngredientes().stream().collect(Collectors.summingDouble(value -> value.getCalories()));

        // obtener ingrediente con mas calorias
        Ingrediente ingrediente = plato.getIngredientes().stream().max(Comparator.comparingDouble(c -> c.getCalories())).get();


          return new ResponsePlatoDTO(caloriasTotales,plato.getIngredientes(),ingrediente);
    }

}
