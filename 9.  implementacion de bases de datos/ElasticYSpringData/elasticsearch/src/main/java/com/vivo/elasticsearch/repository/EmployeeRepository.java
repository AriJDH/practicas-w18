package com.vivo.elasticsearch.repository;

import com.vivo.elasticsearch.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findAllBy();

    List<Employee> findAllByDescriptionIs(String description);

    List<Employee> findAllByDescriptionIn(List<String> description);


}
