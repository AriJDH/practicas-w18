package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String>{

    List<Employee> findAll();

    List<Employee> findAllByDescriptionIs(String description);

    List<Employee> findAllByDescriptionIn(List<String> descriptionWords);

    List<Employee> findAllByDescriptionAndDescription(String des1, String des2);

    List<Employee> findAllByExperiencesGreaterThanEqual(int experience);

    List<Employee> findAllByExperiencesGreaterThan(int experience);

    List<Employee> findAllByNameContaining(String name);
}
