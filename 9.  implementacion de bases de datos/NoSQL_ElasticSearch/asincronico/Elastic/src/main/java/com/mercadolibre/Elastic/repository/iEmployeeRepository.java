package com.mercadolibre.Elastic.repository;

import com.mercadolibre.Elastic.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iEmployeeRepository extends ElasticsearchRepository<Employee, String> {
    List<Employee> findAll();

}
