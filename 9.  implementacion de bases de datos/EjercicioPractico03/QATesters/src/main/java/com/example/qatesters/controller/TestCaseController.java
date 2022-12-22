package com.example.qatesters.controller;

import com.example.qatesters.dto.request.TestCaseRequest;
import com.example.qatesters.dto.response.TestCaseResponse;
import com.example.qatesters.service.IServiceTestCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestCaseController {

    private final IServiceTestCase serviceTestCase;


    @PostMapping("/api/testcases/new")
    public ResponseEntity<TestCaseResponse> createTestCase(@RequestBody TestCaseRequest request) {

        return new ResponseEntity<>(serviceTestCase.createTestCase(request), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseResponse> getTestCaseById(@PathVariable Long id) {

        return new ResponseEntity<>(serviceTestCase.getTestCaseById(id), HttpStatus.OK);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseResponse>> getAllTestCase(
            @RequestParam(required = false, name = "last_update") String lastUpdate) {

        return new ResponseEntity<>(serviceTestCase.getAllTestCase(lastUpdate), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseResponse> updateTestCaseById(@PathVariable Long id, @RequestBody TestCaseRequest request) {

        return new ResponseEntity<>(serviceTestCase.updateTestCase(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<Void> deleteTestCaseById(@PathVariable Long id) {

        serviceTestCase.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
