package com.manejoExcepcionesVivo.youtuber.repository;

import com.manejoExcepcionesVivo.youtuber.entity.EntradaBlog;
import com.manejoExcepcionesVivo.youtuber.exception.IdDuplicadoException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository {
	
	// Nuestra <<Base de datos>> -------------------------------
	List<EntradaBlog> entradaBlogList = new ArrayList<>();
	
	// CRUD -----------------------------------------------------
	@Override
	public EntradaBlog agregarNuevo(EntradaBlog entradaBlog) {
		// Antes de agregar chequeamos si ya existe el Id
		for (EntradaBlog eb : entradaBlogList) {
			eb.getId().equals(entradaBlog.getId());
			// Si el Id existe arrojamos la excepción
			throw new IdDuplicadoException("Id " + entradaBlog.getId() + " Duplicado");
		}
		// Si el Id no existe, agregamos el elemento
		entradaBlogList.add(entradaBlog);
		return entradaBlog;
	}
	
	@Override
	public List<EntradaBlog> buscarTodos() {
		return entradaBlogList;
	}
	
	@Override
	public Optional<EntradaBlog> buscarPorId(Long id) {
		return Optional.of(entradaBlogList
						.stream()
						.filter(entrada -> entrada.getId().equals(id))
						.findFirst()
						.get());
	}
}