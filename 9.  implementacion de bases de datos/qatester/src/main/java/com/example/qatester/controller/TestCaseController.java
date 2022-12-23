package com.example.qatester.controller;

import com.example.qatester.dto.TestCaseRequestDTO;
import com.example.qatester.dto.TestCaseResponseDTO;
import com.example.qatester.service.ITestCaseService;
import com.example.qatester.service.TestCaseServiceImp;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    final TestCaseServiceImp testCaseService;

    public TestCaseController(TestCaseServiceImp testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        testCaseService.saveAndFlush(testCaseRequestDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/description")
    public ResponseEntity<List<TestCaseResponseDTO>> findDescription(@RequestParam String description){
        return new ResponseEntity<>(testCaseService.findByDescription(description), HttpStatus.OK);
    }

}

