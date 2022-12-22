package com.example.empleados.service;

import com.example.empleados.dto.request.EmpleadoRequest;
import com.example.empleados.dto.response.EmpleadoResponse;
import com.example.empleados.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {

    EmpleadoResponse createEmpleado(EmpleadoRequest request);

    EmpleadoResponse updateEmpleado(String id, EmpleadoRequest request);

    List<Empleado> getAllEmpleado();

}
