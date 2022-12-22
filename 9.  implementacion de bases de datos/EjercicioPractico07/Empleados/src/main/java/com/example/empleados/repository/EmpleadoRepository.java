package com.example.empleados.repository;

import com.example.empleados.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    @Override
    List<Empleado> findAll();
}
