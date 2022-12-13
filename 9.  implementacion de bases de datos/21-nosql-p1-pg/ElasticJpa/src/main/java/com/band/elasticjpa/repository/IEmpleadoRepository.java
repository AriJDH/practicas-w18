package com.band.elasticjpa.repository;

import com.band.elasticjpa.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}
