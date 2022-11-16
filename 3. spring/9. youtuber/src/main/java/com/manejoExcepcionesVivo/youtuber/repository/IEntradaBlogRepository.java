package com.manejoExcepcionesVivo.youtuber.repository;

import com.manejoExcepcionesVivo.youtuber.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository{

	EntradaBlog agregarNuevo(EntradaBlog entradaBlog);
	List<EntradaBlog> buscarTodos();
	Optional<EntradaBlog> buscarPorId(Long id);
	
}
