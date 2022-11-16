package com.manejoExcepcionesVivo.youtuber.service;

import com.manejoExcepcionesVivo.youtuber.dto.EntradaBlogDTO;

import java.util.List;

public interface IEntradaBlogService {
	
	Long agregar(EntradaBlogDTO entradaBlogDTO);
	List<EntradaBlogDTO> buscarTodos();
	EntradaBlogDTO buscarPorId(Long id);
	
}
