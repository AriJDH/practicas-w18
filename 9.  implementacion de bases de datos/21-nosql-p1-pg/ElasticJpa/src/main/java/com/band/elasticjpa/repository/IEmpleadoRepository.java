package com.band.elasticjpa.repository;

import com.band.elasticjpa.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    List<Empleado> findAllByNombreIs(String nombre);
    List<Empleado> findAllByNombreIsIn(List<String> nombre);

    List<Empleado> findAllByEdadGreaterThanEqualOrderByEdadDesc(Integer edad);

    List<Empleado> findAllByProvinciaContains(String provincia);
}
