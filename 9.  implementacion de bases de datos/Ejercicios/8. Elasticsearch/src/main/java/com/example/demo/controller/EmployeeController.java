package com.example.demo.controller;

import com.example.demo.model.EmployeeDTO;
import com.example.demo.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	// DEPENDENCIES ------------------------------------- //
	final IEmployeeService employeeService;
	
	public EmployeeController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// CRUD --------------------------------------------- //
	@PostMapping
	public ResponseEntity<?> save(@RequestBody EmployeeDTO employeeDTO) {
		employeeService.save(employeeDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		EmployeeDTO employeeDTO = employeeService.findById(id);
		return ResponseEntity.ok().body(employeeDTO);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<EmployeeDTO> employeeDTOList = employeeService.findAll();
		return ResponseEntity.ok().body(employeeDTOList);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) {
		employeeService.delete(id);
		return ResponseEntity.ok().body("El elemento fue eliminado con éxito");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO) {
		employeeService.update(id, employeeDTO);
		return ResponseEntity.ok("El elemento fue modificado con éxito");
	}
	
}
