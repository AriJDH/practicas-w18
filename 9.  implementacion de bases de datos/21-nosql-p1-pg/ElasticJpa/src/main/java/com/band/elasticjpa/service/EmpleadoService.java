package com.band.elasticjpa.service;

import com.band.elasticjpa.entity.Empleado;
import com.band.elasticjpa.repository.IEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService implements IEmpleadoService{

    private final IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<String> getAllEmpleados() {
        return StreamSupport.stream(empleadoRepository.findAll().spliterator(), false)
                .map(Empleado::getApellido).collect(Collectors.toList());
    }
}
