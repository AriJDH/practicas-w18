package com.HQLHibernateQueryLanguageVIVO.HQL.service;

import com.HQLHibernateQueryLanguageVIVO.HQL.dto.VehiculoDto;
import com.HQLHibernateQueryLanguageVIVO.HQL.model.Vehiculo;
import com.HQLHibernateQueryLanguageVIVO.HQL.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImp implements IVehiculoService {
	
	final ObjectMapper mapper;
	final IVehiculoRepository vehiculoRepository;
	
	public VehiculoServiceImp(IVehiculoRepository vehiculoRepository, ObjectMapper mapper) {
		this.vehiculoRepository = vehiculoRepository;
		this.mapper = mapper;
	}
	
	// Guardar  -------------------------------- //
	@Override
	public void save(VehiculoDto vehiculoDto) {
		Vehiculo vehiculo = mapper.convertValue(vehiculoDto, Vehiculo.class);
		vehiculoRepository.saveAndFlush(vehiculo);
	}
	
	// Buscar Todos  -------------------------------- //
	@Override
	public List<VehiculoDto> findAll() {
		List<Vehiculo> vehiculoList = vehiculoRepository.findAll();
		return vehiculoList
						.stream()
						.map(vehiculo -> mapper.convertValue(vehiculo, VehiculoDto.class))
						.collect(Collectors.toList());
	}
	
	// Buscar por Id  -------------------------------- //
	@Override
	public VehiculoDto findById(Long id) {
		Vehiculo vehiculo = vehiculoRepository.findById(id)
						.orElseThrow(() -> new NoSuchElementException(String.format("No se encontró el id %d", id)));
		return mapper.convertValue(vehiculo, VehiculoDto.class);
	}
	
	// Modificar  -------------------------------- //
	@Override
	public void update(Long id, VehiculoDto vehiculoDto) {
		Vehiculo vehiculo = vehiculoRepository.findById(id)
						.orElseThrow(() -> new NoSuchElementException(String.format("No se encontró el id %d", id)));
		Vehiculo nuevoVehiculo = mapper.convertValue(vehiculoDto, Vehiculo.class);
		nuevoVehiculo.setIdVehiculo(id);
		vehiculoRepository.saveAndFlush(nuevoVehiculo);
	}
	
	// Eliminar  -------------------------------- //
	@Override
	public void deleteById(Long id) {
		Vehiculo vehiculo = vehiculoRepository.findById(id)
						.orElseThrow(() -> new NoSuchElementException(String.format("No se encontró el id %d", id)));
		vehiculoRepository.deleteById(id);
	}
}
