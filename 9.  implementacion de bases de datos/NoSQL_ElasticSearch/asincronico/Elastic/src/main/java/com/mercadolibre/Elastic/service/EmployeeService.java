package com.mercadolibre.Elastic.service;

import com.mercadolibre.Elastic.entity.Employee;
import com.mercadolibre.Elastic.repository.iEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {

    @Autowired
    iEmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
}
