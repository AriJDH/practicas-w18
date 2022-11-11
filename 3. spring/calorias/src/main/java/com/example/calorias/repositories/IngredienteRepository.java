package com.example.calorias.repositories;

import com.example.calorias.Config;
import com.example.calorias.entities.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class IngredienteRepository extends JsonRepository<Ingrediente>{
    public IngredienteRepository() {
        super(Config.INGREDIENTES_FILE_NAME, new TypeReference<List<Ingrediente>>(){});
    }
    public Optional<Ingrediente> findByName(String name){
        return  super.findAll().stream().filter(ingrediente -> ingrediente.getName().contains(name)).findFirst();
    }
}
