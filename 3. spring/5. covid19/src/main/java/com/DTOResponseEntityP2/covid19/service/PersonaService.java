package com.DTOResponseEntityP2.covid19.service;

import com.DTOResponseEntityP2.covid19.model.Persona;
import com.DTOResponseEntityP2.covid19.model.PersonaDTO;
import com.DTOResponseEntityP2.covid19.repository.PersonaRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
	
	@Autowired
	PersonaRepositoryImp personaRepositoryImp;
	@Autowired
	SintomaService sintomaService;
	
	//public List<PersonaDTO> buscarPersonasRiesgo(){
	// TODO pendiente buscar personas de riesgo y ejecutar el sistema
	//}
	
}