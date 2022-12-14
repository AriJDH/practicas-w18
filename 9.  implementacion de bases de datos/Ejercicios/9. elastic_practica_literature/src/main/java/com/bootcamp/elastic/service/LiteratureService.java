package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.DateDTO;
import com.bootcamp.elastic.dto.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LiteratureService implements ILiteratureService{
	
	// DEPENDENCIES ----------------------------------- //
	final LiteratureRepository literatureRepository;
	final ObjectMapper mapper;
	
	public LiteratureService(LiteratureRepository literatureRepository, ObjectMapper mapper) {
		this.literatureRepository = literatureRepository;
		this.mapper = mapper;
	}
	
	// CRUD ----------------------------------- //
	@Override
	public void save(LiteratureDTO literatureDTO) {
	literatureRepository.save(mapper.convertValue(literatureDTO, Literature.class));
	}
	
	@Override
	public void saveAll(List<LiteratureDTO> literatureDTOS){
		List<Literature> literatureList = literatureDTOS
						.stream()
						.map(literatureDTO -> mapper.convertValue(literatureDTO,Literature.class))
						.collect(Collectors.toList());
		literatureRepository.saveAll(literatureList);
	}
	
	@Override
	public LiteratureDTO findById(String id) {
		Literature literatureFound = literatureRepository.findById(id)
						.orElseThrow(()-> new NoSuchElementException("Id no encontrado"));
		return mapper.convertValue(literatureFound, LiteratureDTO.class);
	}
	
	@Override
	public List<LiteratureDTO> findAll() {
		Iterable<Literature> literatureList = literatureRepository.findAll();
		List<LiteratureDTO> literatureDTOList = new ArrayList<>();
		for (Literature literature: literatureList
		     ) {
			literatureDTOList.add(mapper.convertValue(literature, LiteratureDTO.class));
		}
 		return literatureDTOList;
	}
	
	@Override
	public void deleteById(String id) {
		literatureRepository.deleteById(id);
	}
	
	@Override
	public void deleteAll(List<LiteratureDTO> literatureDTOList) {
		List<Literature> literatureList = new ArrayList<>();
		for (LiteratureDTO literatureDTO : literatureDTOList) {
			literatureList.add(mapper.convertValue(literatureDTO, Literature.class));
		}
		literatureRepository.deleteAll(literatureList);
	}
	
	@Override
	public void update(String id, LiteratureDTO literatureDTO) {
		Literature literatureFound =   literatureRepository.findById(id)
						.orElseThrow(()-> new NoSuchElementException("Id no encontrado"));
		Literature newLiterature = mapper.convertValue(literatureDTO, Literature.class);
		newLiterature.setId(id);
		literatureRepository.save(newLiterature);
	}
	
	// OTHERS ----------------------------------- //
	@Override
	public List<LiteratureDTO> getLiteratureByAuthorIs(String author) {
		List<Literature> literatureList = literatureRepository.getLiteratureByAuthorIs(author);
		return literatureList
						.stream()
						.map(literature -> mapper.convertValue(literature, LiteratureDTO.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public List<LiteratureDTO> getLiteratureByTitleIn(List<String> keywords) {
		List<Literature> literatureList= literatureRepository.getLiteratureByTitleIn(keywords);
		return literatureList
						.stream()
						.map(literature -> mapper.convertValue(literature, LiteratureDTO.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public List<LiteratureDTO> getLiteratureByCantPagesGreaterThan(Integer pages) {
		List<Literature> literatureList= literatureRepository.getLiteratureByCantPagesGreaterThan(pages);
		return literatureList
						.stream()
						.map(literature -> mapper.convertValue(literature, LiteratureDTO.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public List<LiteratureDTO> getLiteratureByFirstPostAfterOrderByFirstPost(DateDTO date) {
		List<Literature> literatureList= literatureRepository.getLiteratureByFirstPostAfterOrderByFirstPost(date.getDate());
		return literatureList
						.stream()
						.map(literature -> mapper.convertValue(literature, LiteratureDTO.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public List<LiteratureDTO> getLiteratureByFirstPostBeforeOrderByFirstPost(DateDTO date) {
		List<Literature> literatureList= literatureRepository.getLiteratureByFirstPostBeforeOrderByFirstPost(date.getDate());
		return literatureList
						.stream()
						.map(literature -> mapper.convertValue(literature, LiteratureDTO.class))
						.collect(Collectors.toList());
	}
	
	
	
	@Override
	public List<LiteratureDTO> getLiteratureByEditorialIs(String editorial) {
		List<Literature> literatureList= literatureRepository.getLiteratureByEditorialIs(editorial);
		return literatureList
						.stream()
						.map(literature -> mapper.convertValue(literature, LiteratureDTO.class))
						.collect(Collectors.toList());
	}
	
}
