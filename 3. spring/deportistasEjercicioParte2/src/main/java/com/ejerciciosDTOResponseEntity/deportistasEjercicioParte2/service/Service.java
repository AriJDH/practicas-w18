package com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.service;

import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.DeporteDto;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.PersonaDeportistaDto;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.model.PersonaDto;
import com.ejerciciosDTOResponseEntity.deportistasEjercicioParte2.repository.Repository;

import java.util.ArrayList;
import java.util.List;


public class Service {
	
	Repository repository = new Repository();
	
	public DeporteDto buscarDeporte() {
		DeporteDto deporteEncontrado;
		deporteEncontrado = repository.getDeporteDtoList()
						.stream()
						.findFirst().get();
		return deporteEncontrado;
	}
	
	public List<DeporteDto> buscarTodos() {
		return repository.getDeporteDtoList();
	}
	
	public List<PersonaDeportistaDto> buscarTodosDeportistas() {
		return repository.getDeportistasList();
	}
}