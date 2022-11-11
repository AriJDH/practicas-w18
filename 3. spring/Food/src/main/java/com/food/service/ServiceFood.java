package com.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.DTO.DatosDTO;
import com.food.DTO.PlatoDTO;
import com.food.model.Plato;
import com.food.repository.IRepositiryFood;
import com.food.utils.MapperUtils;

@Service
public class ServiceFood implements IServiceFood {
	
	@Autowired
	IRepositiryFood repoFood;

	@Override
	public DatosDTO getDataDelPlato(PlatoDTO plato) {
		
		
		
		DatosDTO datosDto = new DatosDTO();
		
		Plato platoEntity = MapperUtils.mapTo(plato);
		datosDto.setCaloriasDelPlato("Totald de calroias del plato " + platoEntity.calcularCalorias());
		datosDto.setIngredietnes(platoEntity.getIngredientes());
		datosDto.setIngredienteConMayorCaloria(String.valueOf(platoEntity.getIngredienteConMayorCantidadDeCalorias()));
		return datosDto;
	}

	@Override
	public List<DatosDTO> getDataDeListaDePlatos(List<PlatoDTO> platos) {
		
		List<DatosDTO> listaDatos = new ArrayList<>();
		
		platos.stream().forEach(p -> listaDatos.add(getDataDelPlato(p)));
		
		return listaDatos;
	}

}
