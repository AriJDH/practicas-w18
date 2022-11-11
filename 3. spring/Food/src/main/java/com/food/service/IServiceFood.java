package com.food.service;

import java.util.List;

import com.food.DTO.DatosDTO;
import com.food.DTO.PlatoDTO;

public interface IServiceFood {
	
	DatosDTO getDataDelPlato(PlatoDTO plato);
	
	List<DatosDTO> getDataDeListaDePlatos(List<PlatoDTO> platos);

}
