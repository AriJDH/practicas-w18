package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.entity.Employee;
import com.bootcamp.elastic.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeRepository employeeRepository;

    public EmployeeController ( EmployeeRepository employeeRepository ) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("")
    public ResponseEntity<?> demo () {
        return new ResponseEntity<>(employeeRepository.findAll(), OK);
    }

    @GetMapping("/demo1")
    public ResponseEntity<?> get ( @RequestParam String keyword) {
        return new ResponseEntity<>(employeeRepository.findAllByDescriptionIs(keyword), OK);
    }

    @GetMapping("/demo2")
    public ResponseEntity<?> get2 ( @RequestBody List<String> keywords) {
        return new ResponseEntity<>(employeeRepository.findAllByDescriptionIn(keywords), OK);
    }

    @GetMapping("/demo3")
    public ResponseEntity<?> get3 ( @RequestParam String des1, @RequestParam String des2) {
        return new ResponseEntity<>(employeeRepository.findAllByDescriptionAndDescription(des1, des2), OK);
    }

    @GetMapping("/demo4")
    public ResponseEntity<?> get4 ( @RequestParam int experience) {
        return new ResponseEntity<>(employeeRepository.findAllByExperiencesGreaterThanEqual(experience), OK);
    }

    @GetMapping("/demo5")
    public ResponseEntity<?> get5 ( @RequestParam int experience) {
        return new ResponseEntity<>(employeeRepository.findAllByExperiencesGreaterThan(experience), OK);
    }

    @GetMapping("/demo6")
    public ResponseEntity<?> get6 ( @RequestParam String name) {
        return new ResponseEntity<>(employeeRepository.findAllByNameContaining(name), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create ( @RequestBody Employee employee ) {
        return new ResponseEntity<>(employeeRepository.save(employee), OK);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update ( @RequestBody Employee employee ) {
//        return new ResponseEntity<>(employeeRepository.save(employee), OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete ( @RequestBody Employee employee ) {
//        return new ResponseEntity<>(employeeRepository.save(employee), OK);
//    }
}
