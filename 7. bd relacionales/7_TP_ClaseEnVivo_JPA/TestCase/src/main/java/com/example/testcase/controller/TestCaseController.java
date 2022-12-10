package com.example.testcase.controller;

import com.example.testcase.dto.request.TestCaseDTORequest;
import com.example.testcase.dto.response.TestCaseDTOResponse;
import com.example.testcase.service.imp.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/api/testcases/new")
    ResponseEntity<?> create(@RequestBody TestCaseDTORequest testCase) {
        testCaseService.newTestCase(testCase);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    ResponseEntity<List<TestCaseDTOResponse>> findAll(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update) {
        if (last_update == null){
            return new ResponseEntity<>(testCaseService.getTestCases(), HttpStatus.OK);
        }
        return new ResponseEntity<>(testCaseService.getByLastUpdate(last_update), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    ResponseEntity<TestCaseDTOResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @RequestBody TestCaseDTORequest testCase){
        testCaseService.updateTestCase(testCase, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    ResponseEntity<?> deleteById(@PathVariable Long id){
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

