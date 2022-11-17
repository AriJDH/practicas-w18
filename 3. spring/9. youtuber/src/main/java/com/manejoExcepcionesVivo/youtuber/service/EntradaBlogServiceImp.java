package com.manejoExcepcionesVivo.youtuber.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manejoExcepcionesVivo.youtuber.dto.EntradaBlogDTO;
import com.manejoExcepcionesVivo.youtuber.entity.EntradaBlog;
import com.manejoExcepcionesVivo.youtuber.repository.IEntradaBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService {
	
	// Inyección de dependencias --------------------------------------------
	private final ObjectMapper mapper;
	private final IEntradaBlogRepository entradaBlogRepository;
	
	public EntradaBlogServiceImp(ObjectMapper mapper,
	                             IEntradaBlogRepository entradaBlogRepository) {
		this.mapper = mapper;
		this.entradaBlogRepository = entradaBlogRepository;
	}
	
	// CRUD ------------------------------------------------------------------
	@Override
	public Long agregar(EntradaBlogDTO entradaBlogDTO) {
		EntradaBlog entradaBlog = mapper.convertValue(entradaBlogDTO,
						EntradaBlog.class);
		return entradaBlogRepository.agregarNuevo(entradaBlog).getId();
	}
	
	@Override
	public List<EntradaBlogDTO> buscarTodos() {
		List<EntradaBlog> entradaBlogList = entradaBlogRepository.buscarTodos();
		return entradaBlogList.stream().map(entradaBlog -> mapper.convertValue(entradaBlog,
						EntradaBlogDTO.class)).collect(Collectors.toList());
	}
	
	@Override //
	public EntradaBlogDTO buscarPorId(Long id) {
		EntradaBlog entradaBlog = entradaBlogRepository
						.buscarPorId(id)
						.orElseThrow(NoSuchElementException::new);
		return mapper.convertValue(entradaBlog,
						EntradaBlogDTO.class);
	}
}
