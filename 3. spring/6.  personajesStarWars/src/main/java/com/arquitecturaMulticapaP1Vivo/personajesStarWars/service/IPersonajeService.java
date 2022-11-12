package com.arquitecturaMulticapaP1Vivo.personajesStarWars.service;

import com.arquitecturaMulticapaP1Vivo.personajesStarWars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
	public List<PersonajeDTO> getPersonajes(String query);
}
