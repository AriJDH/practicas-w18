package com.example.empleados.repository;

import com.example.empleados.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado,Long> {
}
