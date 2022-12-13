package com.mercadolibre.elasticsearch.repository;

import com.mercadolibre.elasticsearch.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findAllBy();

    List<Employee> findAllByDescriptionIs(String keyword);
    List<Employee> findAllByDescriptionIn(List<String> keywords);
    List<Employee> findAllByExperienceGreaterThanEqual(Integer experience);

}
