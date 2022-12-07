package com.example.qatester.controller;

import com.example.qatester.dto.ResponseDto;
import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.TestCaseDtoReq;
import com.example.qatester.service.ITestCaseService;
import com.example.qatester.service.TestCaseServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {

    private ITestCaseService testCaseService;

    public TestCaseController(TestCaseServiceImp serv){
        this.testCaseService = serv;
    }

    @PostMapping("/testcases/new")
    public ResponseEntity<ResponseDto> createTestCase(@RequestBody TestCaseDtoReq testCase){
        testCaseService.saveTestCase(testCase);
        ResponseDto response = new ResponseDto("Jewerly save ok",201);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/testcases")
    public ResponseEntity<List<TestCaseDto>> getTestCases(){
         return new ResponseEntity<>(testCaseService.getTestCaseDtos(), HttpStatus.OK);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCaseDto> getTestCases(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TestCaseDto> editTestCase(@PathVariable Long id,
                         @RequestBody TestCaseDtoReq TestCase){
        return new ResponseEntity<>(testCaseService.updateTestCaseDto(id, TestCase),HttpStatus.OK);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        testCaseService.deleteTestCaseDto(id);
        ResponseDto response = new ResponseDto( "TestCase deleted ok",200);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/testcases?last_update=date")
    public ResponseEntity<List<TestCaseDto>> getTestCases(@PathVariable String date){
        return new ResponseEntity<>(testCaseService.getTestCaseByDate(date), HttpStatus.OK);
    }

}
