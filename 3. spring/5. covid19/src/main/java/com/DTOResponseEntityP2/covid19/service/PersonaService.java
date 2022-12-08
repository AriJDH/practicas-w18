package com.DTOResponseEntityP2.covid19.service;

import com.DTOResponseEntityP2.covid19.model.Persona;
import com.DTOResponseEntityP2.covid19.model.PersonaDTO;
import com.DTOResponseEntityP2.covid19.repository.PersonaRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
	
	final
	PersonaRepositoryImp personaRepositoryImp;
	final
	SintomaService sintomaService;
	final
	ObjectMapper mapper;
	
	public PersonaService(PersonaRepositoryImp personaRepositoryImp,
	                      SintomaService sintomaService,
	                      ObjectMapper mapper) {
		this.personaRepositoryImp = personaRepositoryImp;
		this.sintomaService = sintomaService;
		this.mapper = mapper;
	}
	
	// Buscar personas de riesgo -------------------------------------- //
	public List<PersonaDTO> buscarPersonasRiesgo() {
		List<Persona> personaList = personaRepositoryImp.buscarTodos();
		return personaList.stream()
						.filter(persona -> persona.getEdad() > 60 && persona.getTieneSintomas())
						.map(persona -> mapper.convertValue(persona, PersonaDTO.class))
						.collect(Collectors.toList());
	}
}