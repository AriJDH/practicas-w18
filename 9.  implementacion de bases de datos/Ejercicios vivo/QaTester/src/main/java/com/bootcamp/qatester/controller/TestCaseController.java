package com.bootcamp.qatester.controller;


import java.util.List;

import com.bootcamp.qatester.dto.request.TestCaseDtoRequest;
import com.bootcamp.qatester.dto.response.TestCaseDtoReponseStatusMessage;
import com.bootcamp.qatester.dto.response.TestCaseDtoResponse;
import com.bootcamp.qatester.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    TestCaseService testCaseService;
    @PostMapping("/new")
    public ResponseEntity<TestCaseDtoReponseStatusMessage> newTest(@RequestBody TestCaseDtoRequest testCaseDtoRequest){
        TestCaseDtoReponseStatusMessage testCaseDtoReponseStatusMessage = testCaseService.save(testCaseDtoRequest);
        return ResponseEntity.status(testCaseDtoReponseStatusMessage.getStatus()).body(testCaseDtoReponseStatusMessage);
    }
    @GetMapping
    public ResponseEntity<List<TestCaseDtoResponse>> findAll(){
        List<TestCaseDtoResponse> responseList = testCaseService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDtoResponse> findById (@PathVariable  Long id){
        TestCaseDtoResponse testCaseDtoResponse = testCaseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseDtoResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDtoReponseStatusMessage> updateById(@PathVariable Long id, @RequestBody TestCaseDtoRequest testCaseDtoRequest){
        TestCaseDtoReponseStatusMessage testCaseDtoReponseStatusMessage = testCaseService.update(id, testCaseDtoRequest);
        return ResponseEntity.status(testCaseDtoReponseStatusMessage.getStatus()).body(testCaseDtoReponseStatusMessage);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TestCaseDtoReponseStatusMessage> deleteById(@PathVariable Long id){
        TestCaseDtoReponseStatusMessage testCaseDtoReponseStatusMessage = testCaseService.delete(id);
        return ResponseEntity.status(testCaseDtoReponseStatusMessage.getStatus()).body(testCaseDtoReponseStatusMessage);
    }
    @GetMapping("/date")
    public ResponseEntity<List<TestCaseDtoResponse>> findAllByLastUpdateAfter(@RequestParam(value = "last_update", required = false) String date) {
        if(date == null) {
            return ResponseEntity.ok(testCaseService.findAll());
        }
        return ResponseEntity.ok(testCaseService.findAllByLastUpdateAfter(date));
    }



    }
