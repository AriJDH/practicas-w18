package com.meli.testcasesjpa.controller;

import com.meli.testcasesjpa.model.request.TestCaseRequest;
import com.meli.testcasesjpa.model.response.TestCaseResponse;
import com.meli.testcasesjpa.service.ITestCasesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/testcases")
public class TestCasesController {

    // ? ================= Attributes =================

    private final ITestCasesService testCasesService;

    // ? ================= Methods =================

    // ! ==== [GET] ====

    // * =========

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(testCasesService.findById(id));
    }

    // * =========

    @GetMapping
    public ResponseEntity<List<TestCaseResponse>> findAllByLastUpdateAfter(@RequestParam(value = "last_update", required = false) String date) {
        if(date == null) {
            return ResponseEntity.ok(testCasesService.findAll());
        }
        return ResponseEntity.ok(testCasesService.findAllByLastUpdateAfter(date));
    }

    // ! ==== [POST] ====

    @PostMapping("/new")
    public ResponseEntity<TestCaseResponse> save(@RequestBody TestCaseRequest testCase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testCasesService.save(testCase));
    }

    // ! ==== [PUT] ====

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseRequest> update(@PathVariable Long id, @RequestBody TestCaseResponse testCase) {
        return ResponseEntity.ok(testCasesService.update(id, testCase));
    }

    // ! ==== [DELETE] ====

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        testCasesService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
