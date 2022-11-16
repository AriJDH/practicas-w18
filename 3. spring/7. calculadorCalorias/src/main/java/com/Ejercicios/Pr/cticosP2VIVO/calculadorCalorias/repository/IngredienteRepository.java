package com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.repository;

import com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.Config;
import com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class IngredienteRepository extends JsonRepository<Ingrediente>{
	public IngredienteRepository() {
		super(Config.INGREDIENTES_FILE_NAME, new TypeReference<List<Ingrediente>>(){});
	}
	public Optional<Ingrediente> findByName(String name){
		return  super.findAll().stream().filter(ingrediente -> ingrediente.getName().contains(name)).findFirst();
	}
}
