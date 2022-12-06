package com.example.testcases.controller;

import com.example.testcases.dtos.ResponseDTO;
import com.example.testcases.model.TestCase;
import com.example.testcases.service.TestCaseDbService;
import com.example.testcases.service.TestCaseDbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private TestCaseDbService testCaseDbService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createTestCase(@RequestBody TestCase testCase){
        testCaseDbService.createTestCase(testCase);
        return ResponseEntity.ok(new ResponseDTO("El caso de test fue creado exitosamente.", 200));
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> findAllTestCases(){
        return ResponseEntity.ok(testCaseDbService.findAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> findTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseDbService.findTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase){
        testCaseDbService.updateTestCase(id, testCase);
        return ResponseEntity.ok(new ResponseDTO("El caso de test fue actulizado exitosamente.", 200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTestCase(@PathVariable Long id){
        testCaseDbService.deleteTestCase(id);
        return ResponseEntity.ok(new ResponseDTO("El caso de test fue eliminado exitosamente", 200));
    }

    @GetMapping("/updatedAfter")
    public ResponseEntity<List<TestCase>> findAllTestCasesUpdatedAfterDate
            (@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update) {
        return ResponseEntity.ok(testCaseDbService.findAllTestCasesUpdatedAfterDate(last_update));
    }
}
