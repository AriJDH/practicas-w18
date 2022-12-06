package com.example.qatesters.controller;

import com.example.qatesters.entity.TestCase;
import com.example.qatesters.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestCaseController {

    @Autowired
    ITestService service;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase newTestCase){
        return new ResponseEntity<>(service.createTestCase(newTestCase), HttpStatus.CREATED);
    }

    @PutMapping ("/api/testcases/{id}")
    public ResponseEntity<TestCase> updateTestCase(@PathVariable Long id, @RequestBody TestCase newTestCase){
        return new ResponseEntity<>(service.updateTestCase(id, newTestCase), HttpStatus.OK);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCase>> getTestCases(){
        return new ResponseEntity<>(service.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> getTestCases(@PathVariable Long id){
        return new ResponseEntity<>(service.getTestCaseById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> deleteTestCase(@PathVariable Long id){
        service.deleteTestCaseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/testcases/query")
    public ResponseEntity<List<TestCase>> getTestCases(@RequestParam String last_update){
        return new ResponseEntity<>(service.getTestCasesByQuery(last_update), HttpStatus.OK);
    }

}
