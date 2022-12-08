package com.HQLHibernateQueryLanguageVIVO.HQL.service;

import com.HQLHibernateQueryLanguageVIVO.HQL.dto.VehiculoDto;
import com.HQLHibernateQueryLanguageVIVO.HQL.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {

	void save(VehiculoDto vehiculoDto);
	List<VehiculoDto> findAll();
	VehiculoDto findById(Long id);
	void update(Long id, VehiculoDto vehiculoDto);
	void deleteById(Long id);
	
	
}
