package com.example.empleados.service;

import com.example.empleados.domain.Empleado;

import java.util.List;

public interface EmpleadoDbService {
    public List<Empleado> findAll();
    public Empleado save(Empleado empleado);
    public void deleteById(String id);
}
