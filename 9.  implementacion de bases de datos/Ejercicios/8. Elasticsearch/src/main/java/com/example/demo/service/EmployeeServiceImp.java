package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDTO;
import com.example.demo.repository.IEmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImp implements IEmployeeService {
	
	// DEPENDENCIES --------------------------------------------- //
	
	final ObjectMapper mapper;
	final IEmployeeRepository employeeRepository;
	
	public EmployeeServiceImp(ObjectMapper objectMapper, IEmployeeRepository employeeRepository) {
		this.mapper = objectMapper;
		this.employeeRepository = employeeRepository;
	}
	
	// CRUD --------------------------------------------- //
	@Override
	public void save(EmployeeDTO employeeDTO) {
		Employee employee = mapper.convertValue(employeeDTO, Employee.class);
		employeeRepository.save(employee);
	}
	
	@Override
	public EmployeeDTO findById(String id) {
		Employee employeeFound = employeeRepository.findById(id)
						.orElseThrow(() -> new NoSuchElementException("El id no fue encontrado"));
		return mapper.convertValue(employeeFound, EmployeeDTO.class);
	}
	
	@Override
	public List<EmployeeDTO> findAll() {
		Iterable<Employee> employeeListFound = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		for (Employee employee : employeeListFound) {
			employeeDTOList.add(mapper.convertValue(employee, EmployeeDTO.class));
		}
		return employeeDTOList;
	}
	
	@Override
	public void delete(String id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public void update(String id, EmployeeDTO employeeDTO) {
		Employee employeeFound = employeeRepository.findById(id)
						.orElseThrow(() -> new NoSuchElementException("El id no fue encontrado"));
		Employee newEmployee = mapper.convertValue(employeeDTO, Employee.class);
		newEmployee.setId(id);
		employeeRepository.save(newEmployee);
	}
}
