package com.dh.qatester.controller;

import com.dh.qatester.dto.TestCaseDtoReq;
import com.dh.qatester.dto.TestCaseDtoRes;
import com.dh.qatester.service.ITestCaseService;
import com.dh.qatester.service.TestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestController {

    private final ITestCaseService testCaseService;

    public TestController(TestCaseService testService) {
        this.testCaseService = testService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(
            @RequestBody TestCaseDtoReq testCaseDto
    )  {
        testCaseService.createTestCase(testCaseDto);
        return ResponseEntity.ok().body("TestCase created successfully");
    }

    @GetMapping()
    public ResponseEntity<?> findAllTestCase(
            @RequestParam(required = false) String last_update
    ){
        if(last_update != null)
            findTestCaseByDate(last_update);
        List<TestCaseDtoRes> testCaseDtos = testCaseService.findAll();
        return ResponseEntity.ok().body(testCaseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTestCaseById(
            @PathVariable Long id
    ){
        TestCaseDtoRes testCaseDto = testCaseService.findById(id);
        return ResponseEntity.ok().body(testCaseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(
            @PathVariable Long id,
            @RequestBody TestCaseDtoReq testCaseDto
    ){
        TestCaseDtoRes testCaseDtoRes = testCaseService.updateTestCase(id, testCaseDto);
        return ResponseEntity.ok().body(testCaseDtoRes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(
            @PathVariable Long id
    ) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.ok().body("TestCase deleted successfully");
    }

    private ResponseEntity<?> findTestCaseByDate(String last_update)
    {
        List<TestCaseDtoRes> testCaseDtos = testCaseService.findTestCaseByDate(last_update);
        return ResponseEntity.ok().body(testCaseDtos);
    }


}
