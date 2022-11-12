package com.DTOResponseEntityP2.covid19.repository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IRepository<T> {
	// Usamos la misma interface Repository para ambas clases (por eso usamos T/generics)
	List<T> buscarTodos();
	T buscarPorNombre(String nombre);
	
}
