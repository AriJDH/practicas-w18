package com.band.elasticjpa.service;

import com.band.elasticjpa.dto.EmpleadoNameListRequest;
import com.band.elasticjpa.dto.EmpleadoDto;
import com.band.elasticjpa.entity.Empleado;
import com.band.elasticjpa.repository.IEmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService implements IEmpleadoService{

    private final IEmpleadoRepository empleadoRepository;
    private final ModelMapper modelMapper;

    public EmpleadoService(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public List<EmpleadoDto> getAllEmpleados() {
        return StreamSupport.stream(empleadoRepository.findAll().spliterator(), false)
                .map(empleado -> modelMapper.map(empleado, EmpleadoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDto addEmpleado(EmpleadoDto empleadoDto) {
        return modelMapper.map(
                empleadoRepository.save(modelMapper.map(empleadoDto, Empleado.class)),
                EmpleadoDto.class);
    }

    @Override
    public List<EmpleadoDto> getAllEmpleadosByNombre(String nombre) {
        return empleadoRepository.findAllByNombreIs(nombre).stream()
                .map(empleado -> modelMapper.map(empleado, EmpleadoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoDto> getAllEmpleadosByNombreList(EmpleadoNameListRequest empleadoNameListRequest) {
        return empleadoRepository.findAllByNombreIsIn(empleadoNameListRequest.getNombreList()).stream()
                .map(empleado -> modelMapper.map(empleado, EmpleadoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoDto> getAllEmpleadosByEdadGreaterThanEqualOrderByEdadDesc(Integer edad) {
        return empleadoRepository.findAllByEdadGreaterThanEqualOrderByEdadDesc(edad).stream()
                .map(empleado -> modelMapper.map(empleado, EmpleadoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoDto> getAllEmpleadosByProvinciaContains(String provincia) {
        return empleadoRepository.findAllByProvinciaContains(provincia).stream()
                .map(empleado -> modelMapper.map(empleado, EmpleadoDto.class))
                .collect(Collectors.toList());
    }
}
