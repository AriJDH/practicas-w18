package com.example.empleados.repository;

import com.example.empleados.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado,String> {
    Empleado save(Empleado empleado);

    List<Empleado> findAll();

    void deleteById(String id);
}
