package com.example.elasticsearchspringempleados.repostiroy;

import com.example.elasticsearchspringempleados.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado,String>{
}
