package com.food.utils;

import com.food.DTO.PlatoDTO;
import com.food.model.Plato;

public class MapperUtils {

	public static Plato mapTo(PlatoDTO platoDto) {
		Plato plato = new Plato(platoDto.getNombre(), platoDto.getPesoEnGramo(), platoDto.getIngredientes());
		return plato;
	}
	
}
