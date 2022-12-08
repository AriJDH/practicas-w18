package com.arquitecturaMulticapaP1Vivo.personajesStarWars.repositories;

import com.arquitecturaMulticapaP1Vivo.personajesStarWars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
	
	List<Personaje> findAll();
	
	void loadList();
}
