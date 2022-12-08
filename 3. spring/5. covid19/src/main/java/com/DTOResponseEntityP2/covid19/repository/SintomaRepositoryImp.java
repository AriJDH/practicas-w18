package com.DTOResponseEntityP2.covid19.repository;

import com.DTOResponseEntityP2.covid19.model.NivelDeGravedad;
import com.DTOResponseEntityP2.covid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepositoryImp implements IRepository<Sintoma> {
	
	// Tests
	Sintoma sintoma1 = new Sintoma(1L, "Sintoma1", NivelDeGravedad.grave);
	Sintoma sintoma2 = new Sintoma(2L, "Sintoma2", NivelDeGravedad.leve);
	Sintoma sintoma3 = new Sintoma(3L, "Sintoma3", NivelDeGravedad.grave);
	
	// Nuestras <<Bases de datos>>
	List<Sintoma> sintomas = new ArrayList<>() {{
		add(sintoma1);
		add(sintoma2);
		add(sintoma3);
	}};
	
	// Buscar
	public List<Sintoma> buscarTodos() {
		return sintomas;
	}
	
	public Sintoma buscarPorNombre(String nombre) {
		List<Sintoma> sintomasBuscados = buscarTodos();
		Sintoma sintomaEncontrado = sintomasBuscados
						.stream()
						.filter(sintoma -> sintoma.getNombre().equals(nombre)).findFirst()
						.orElseThrow(() -> new RuntimeException("Sintoma no encontrado"));
		return sintomaEncontrado;
	}
	
}
