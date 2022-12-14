package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.DateDTO;
import com.bootcamp.elastic.dto.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;

import java.time.LocalDate;
import java.util.List;

public interface ILiteratureService {
	
	// CRUD ----------------------------------- //
	void save(LiteratureDTO literatureDTO);
	void saveAll(List<LiteratureDTO> literatureDTOList);
	LiteratureDTO findById(String id);
	List<LiteratureDTO> findAll();
	void deleteById(String id);
	void deleteAll(List<LiteratureDTO> literatureDTOList);
	void update(String id, LiteratureDTO literatureDTO);
	
	// OTHERS ----------------------------------- //
	// Retornar las obras de un autor dado por el usuario.
	List<LiteratureDTO> getLiteratureByAuthorIs(String author);
	
	// Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
	List<LiteratureDTO> getLiteratureByTitleIn(List<String> keywords);
	
	// Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
	List<LiteratureDTO> getLiteratureByCantPagesGreaterThan(Integer pages);
	
	// Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
	List<LiteratureDTO> getLiteratureByFirstPostAfterOrderByFirstPost(DateDTO date);
	List<LiteratureDTO> getLiteratureByFirstPostBeforeOrderByFirstPost(DateDTO date);
	
	
	// Retornar las obras de una misma editorial.
	List<LiteratureDTO> getLiteratureByEditorialIs(String editorial);
	
}
