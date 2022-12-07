package com.example.qatesters.controller;

import com.example.qatesters.dto.request.TestCaseDTOReq;
import com.example.qatesters.dto.response.GenericsDTORes;
import com.example.qatesters.dto.response.TestCaseDTORes;
import com.example.qatesters.service.ITestCaseService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    ResponseEntity<TestCaseDTORes> create(@RequestBody TestCaseDTOReq testCaseDTOReq){
        return new ResponseEntity<>(testCaseService.create(testCaseDTOReq), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<TestCaseDTORes>> findAll(){
        return new ResponseEntity<>(testCaseService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<TestCaseDTORes> findById(@PathVariable Long id){
        return new ResponseEntity<> (testCaseService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<TestCaseDTORes> updateById(@PathVariable Long id,@RequestBody TestCaseDTOReq testCaseDTOReq){
        return new ResponseEntity<>(testCaseService.updateById(id,testCaseDTOReq),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<GenericsDTORes> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteById(id),HttpStatus.OK);
    }

    @GetMapping("/dates")
    ResponseEntity<List<TestCaseDTORes>> findByDate(@RequestParam String last_update){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(last_update,formatter);
        return new ResponseEntity<>(testCaseService.findByDate(localDate),HttpStatus.OK);
    }

}
