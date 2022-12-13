package com.example.empleados.service;

import com.example.empleados.domain.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {
    Empleado save(Empleado empleado);

    List<Empleado> findAll();

    Empleado findById(String id);

    Empleado update(String id,Empleado empleado);

    void deleteById(String id);
}
