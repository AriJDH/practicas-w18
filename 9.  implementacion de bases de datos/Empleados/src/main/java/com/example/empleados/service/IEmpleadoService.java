package com.example.empleados.service;

import com.example.empleados.dto.EmpleadoDto;
import com.example.empleados.dto.Response;

import java.util.List;

public interface IEmpleadoService {

    Response create(EmpleadoDto empleado);

    Response update(EmpleadoDto empleado);

    List<EmpleadoDto> findAll();

    EmpleadoDto findById(String id);
}
