package com.CRUDconJPA.JoyeriaLasPerlas.service;

import com.CRUDconJPA.JoyeriaLasPerlas.dto.JoyaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IJoyaService {

	// -------------------------------- CRUD -------------------------------- //
	// Gurdar -------------------------------- //
	JoyaDto saveAndFlush(JoyaDto joyaDto);
	// Buscar todos -------------------------------- //
	List<JoyaDto> findAll();
	// Buscar por id -------------------------------- //
	JoyaDto findById(Long id);
	// Eliminar por id -------------------------------- //
	void deleteById(Long id);
	// Modificar -------------------------------- //
	void update(JoyaDto joyaDto);

}
