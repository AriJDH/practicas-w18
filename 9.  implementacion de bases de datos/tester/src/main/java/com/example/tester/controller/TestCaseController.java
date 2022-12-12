package com.example.tester.controller;

import com.example.tester.dto.response.TestCaseResponse;
import com.example.tester.exceptions.BadRequestException;
import com.example.tester.model.entity.TestCase;
import com.example.tester.service.ITesterCaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestCaseController {

    // ======== Attributes =========
    private final ITesterCaseService testerCaseService;

    // ======== Get without parameters =====
    @GetMapping("/testcases")
    public ResponseEntity<List<TestCase>> getAllTestCasesByDate(@RequestParam(value = "last_update", required = false) LocalDate lastUpdate){
        return new ResponseEntity<>(lastUpdate != null ? this.testerCaseService.getTesterCase(lastUpdate) : this.testerCaseService.getTesterCase(), HttpStatus.OK);
    }

    @GetMapping("/testcases/id")
    public ResponseEntity<TestCase> findTesteCasesById(@PathVariable Long idCase)
    {
        return new ResponseEntity<>(this.testerCaseService.findTesterCase(idCase),HttpStatus.OK);
    }

    @DeleteMapping("/testcases/id")
    public ResponseEntity<TestCaseResponse> deleteTesteCasesById(@PathVariable Long idCase)
    {
        return new ResponseEntity<>(this.testerCaseService.deleteTesterCase(idCase),HttpStatus.OK);
    }

    @PutMapping("/testcases/id")
    public ResponseEntity<TestCaseResponse> editTesteCasesById(@PathVariable Long idCase, @RequestBody TestCase testCase)
    {
        try {
            return new ResponseEntity<>(this.testerCaseService.editTesterCase(idCase, testCase),HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @PostMapping("/testcases/new")
    public ResponseEntity<TestCaseResponse> saveTestCases(@RequestBody TestCase testCase){
        return new ResponseEntity<>(this.testerCaseService.saveTesterCase(testCase),HttpStatus.OK);
    }



}
