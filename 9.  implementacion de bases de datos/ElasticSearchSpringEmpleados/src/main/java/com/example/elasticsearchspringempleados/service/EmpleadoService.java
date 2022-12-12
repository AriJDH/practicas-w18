package com.example.elasticsearchspringempleados.service;

import com.example.elasticsearchspringempleados.domain.Empleado;
import com.example.elasticsearchspringempleados.repostiroy.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private IEmpleadoRepository repo;

    public Empleado create(Empleado empleado){
        return repo.save(empleado);
    }

    public List<Empleado> getAll() {
        List<Empleado> empleados = new ArrayList<>();
        Iterable<Empleado> empleadoIterable = repo.findAll();
        empleadoIterable.forEach(e -> empleados.add(e));
        return empleados;
    }

    public Empleado update(Empleado empleado) {

        return repo.save(empleado);
    }
}
