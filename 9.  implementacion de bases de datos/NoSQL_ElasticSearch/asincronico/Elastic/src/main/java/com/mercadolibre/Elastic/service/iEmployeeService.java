package com.mercadolibre.Elastic.service;

import com.mercadolibre.Elastic.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface iEmployeeService {

    Employee saveEmployee (Employee employee);
    List<Employee> findAllEmployees();
}
