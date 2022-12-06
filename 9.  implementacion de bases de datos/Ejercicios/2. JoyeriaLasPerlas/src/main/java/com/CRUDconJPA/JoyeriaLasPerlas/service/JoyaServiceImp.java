package com.CRUDconJPA.JoyeriaLasPerlas.service;

import com.CRUDconJPA.JoyeriaLasPerlas.dto.JoyaDto;
import com.CRUDconJPA.JoyeriaLasPerlas.model.Joya;
import com.CRUDconJPA.JoyeriaLasPerlas.repository.JoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImp implements IJoyaService {
	
	// Inyección de dependencias
	JoyaRepository joyaRepository;
	ObjectMapper mapper;
	
	public JoyaServiceImp(JoyaRepository joyaRepository,
	                      ObjectMapper mapper) {
		this.joyaRepository = joyaRepository;
		this.mapper = mapper;
	}
	
	
	// Guardar ---------------------------------------------- //
	@Override
	public JoyaDto saveAndFlush(JoyaDto joyaDto) {
		Joya joya = mapper.convertValue(joyaDto, Joya.class);
		joya.setVentaONo(true);
		joyaRepository.saveAndFlush(joya);
		return mapper.convertValue(joya, JoyaDto.class);
	}
	
	// Buscar  ---------------------------------------------- //
	@Override
	public List<JoyaDto> findAll() {
		List<Joya> joyaList = joyaRepository.findAll();
		List<Joya> filterList = joyaList
						.stream()
						.filter(Joya::isVentaONo)
						.collect(Collectors.toList());
		return filterList
						.stream()
						.map(joya -> mapper.convertValue(joya, JoyaDto.class))
						.collect(Collectors.toList());
		
	}
	
	@Override
	public JoyaDto findById(Long id) {
		Joya joya = joyaRepository
						.findById(id)
						.orElseThrow(() ->
										             new NoSuchElementException(String.format(
														             "No existe el id %d",
														             id)));
		return mapper.convertValue(joya, JoyaDto.class);
		
	}
	
	// Eliminar ---------------------------------------------- //
	@Override
	public void deleteById(Long id) {
		// Buscamos si el Id existe
		Joya joya = joyaRepository
						.findById(id)
						.orElseThrow(() ->
										             new NoSuchElementException(String.format(
														             "No existe el id %d",
														             id)));
		if (joya.isVentaONo()) {
			joya.setVentaONo(false);
		}
		
		// El eliminado es lógico, por lo que no elimina el registro, sino que lo modifica
		joyaRepository.saveAndFlush(joya);
	}
	
	// Modificar ---------------------------------------------- //
	@Override
	public void update(JoyaDto joyaDto) {
		Joya joya = mapper.convertValue(joyaDto, Joya.class);
		joyaRepository.saveAndFlush(joya);
	}
}
