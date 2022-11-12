package com.DTOResponseEntityP2.covid19.service;

import com.DTOResponseEntityP2.covid19.model.Sintoma;
import com.DTOResponseEntityP2.covid19.repository.SintomaRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class SintomaService {
	
	@Autowired
	SintomaRepositoryImp sintomaRepositoryImp;
	
	// Ver todos los sintomas cargados
	public List<Sintoma> buscarTodos(){
		return sintomaRepositoryImp.buscarTodos();
	}
	
	// Buscar un sintoma por su nombre
	public Sintoma buscarPorNombre(String nombre){
		return sintomaRepositoryImp.buscarPorNombre(nombre);
	}
	
}
