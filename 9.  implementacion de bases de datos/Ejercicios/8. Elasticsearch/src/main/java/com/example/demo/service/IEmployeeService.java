package com.example.demo.service;

import com.example.demo.model.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
	
	// CRUD --------------------------------------------- //
	void save(EmployeeDTO employeeDTO);
	EmployeeDTO findById(String id);
	List<EmployeeDTO> findAll();
	void delete(String id);
	void update(String id,EmployeeDTO employeeDTO);
}
