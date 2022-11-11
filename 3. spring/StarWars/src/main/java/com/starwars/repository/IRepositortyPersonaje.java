package com.starwars.repository;

import java.util.List;

import com.starwars.model.Personaje;

public interface IRepositortyPersonaje {
	
	List<Personaje> getByName(String name);

}
