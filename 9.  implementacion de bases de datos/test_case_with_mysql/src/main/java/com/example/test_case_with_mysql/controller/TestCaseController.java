package com.example.test_case_with_mysql.controller;

import com.example.test_case_with_mysql.dto.CreateTestCaseDTO;
import com.example.test_case_with_mysql.dto.ResultadoDTO;
import com.example.test_case_with_mysql.dto.SearchTestDTO;
import com.example.test_case_with_mysql.dto.TestDTO;
import com.example.test_case_with_mysql.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService iTestCaseService;

    public TestCaseController(ITestCaseService iTestCaseService) {
        this.iTestCaseService = iTestCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<ResultadoDTO> createTest(@RequestBody CreateTestCaseDTO createTestCaseDTO) {
        return new ResponseEntity<>(this.iTestCaseService.createTest(createTestCaseDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResultadoDTO> updateTest(@RequestParam Long id) {
        return new ResponseEntity<>(this.iTestCaseService.updateTest(id), HttpStatus.OK);
    }

    @GetMapping("/getTests")
    public ResponseEntity<SearchTestDTO> getTests() {
        return new ResponseEntity<>(this.iTestCaseService.getTests(), HttpStatus.OK);
    }

    @GetMapping("/getTest")
    public ResponseEntity<TestDTO> getTest(@RequestParam Long id) {
        return new ResponseEntity<>(this.iTestCaseService.getTest(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResultadoDTO> deleteTest(@RequestParam Long id) {
        return new ResponseEntity<>(this.iTestCaseService.deleteTest(id), HttpStatus.OK);
    }

    @GetMapping("/getTestToDate")
    public ResponseEntity<SearchTestDTO> getTestsToDate(@RequestParam String fecha) {
        return new ResponseEntity<>(this.iTestCaseService.getTestsToDate(fecha), HttpStatus.OK);
    }
}
