package com.arquitecturaMulticapaP1Vivo.personajesStarWars.service;

import com.arquitecturaMulticapaP1Vivo.personajesStarWars.dto.PersonajeDTO;
import com.arquitecturaMulticapaP1Vivo.personajesStarWars.entity.Personaje;
import com.arquitecturaMulticapaP1Vivo.personajesStarWars.repositories.IPersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService {
	
	final IPersonajeRepository personajeRepository;
	
	public PersonajeServiceImp(IPersonajeRepository personajeRepository) {
		this.personajeRepository = personajeRepository;
	}
	
	@Override
	public List<PersonajeDTO> getPersonajes(String query) {
		ObjectMapper op = new ObjectMapper();
		
		List<Personaje> personajes = personajeRepository.findAll();
		return personajes.stream()
						.filter(p -> p.getName().contains(query))
						.map(p -> op.convertValue(p, PersonajeDTO.class))
						.collect(Collectors.toList());
	}
}
