package com.mercadolibre.elasticsearch.controller;

import com.mercadolibre.elasticsearch.entity.Employee;
import com.mercadolibre.elasticsearch.repository.IEmployeeRepository;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> getAll() {
        Iterable<Employee> employeeList = employeeRepository.findAll();
        return new ResponseEntity<>(employeeList, OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<?> create(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeRepository.save(employee), CREATED);
    }
    @GetMapping("/find")
    public ResponseEntity<?> searchDescription(@RequestParam String keyword){
        return new ResponseEntity<>(employeeRepository.findAllByDescriptionIs(keyword), OK);
    }
    @GetMapping("/findList")
    public ResponseEntity<?> searchDescription(@RequestBody List<String> keywords){
        return new ResponseEntity<>(employeeRepository.findAllByDescriptionIn(keywords), OK);
    }

}
