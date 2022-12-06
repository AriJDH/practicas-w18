package com.jpa.joyeria.controller;

import com.jpa.joyeria.model.TestCase;
import com.jpa.joyeria.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private TestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<TestCase> create(@RequestBody TestCase testCase){
        return new ResponseEntity<>(service.save(testCase), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<TestCase>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getTestCase(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TestCase>update(@RequestBody TestCase testCase, @PathVariable Long id){
        return new ResponseEntity<>(service.update(testCase,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
   @GetMapping("/lastupdate")
   public ResponseEntity<List<TestCase>> getByLastUpdate( @RequestParam String last_update){
        return new ResponseEntity<>(service.getByLastUpdate(last_update),HttpStatus.OK);
    }


}
