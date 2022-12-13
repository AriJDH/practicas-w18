package meli.bootcamp.empleados.service;

import meli.bootcamp.empleados.domain.Empleado;

import java.util.List;

public interface IEmpleadoService {
    void addEmpleado(Empleado empleado);
    void modifyEmpleado(String id, Empleado empleado);

    List<Empleado> findAllByDescriptionIs(String descripcion);

    List<Empleado> findAllByDescriptionIn(List<String> descripcion);

    List<Empleado> findAll();
}
