package com.example.empresa_elasticsearch.repository;

import com.example.empresa_elasticsearch.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    List<Empleado> findByNombreUnico(String nombre);
}
