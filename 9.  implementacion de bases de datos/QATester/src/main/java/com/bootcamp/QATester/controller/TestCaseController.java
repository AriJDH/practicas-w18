package com.bootcamp.QATester.controller;

import com.bootcamp.QATester.dto.req.TestCaseReqDto;
import com.bootcamp.QATester.dto.views.TestCaseResDto;
import com.bootcamp.QATester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody TestCaseReqDto testCaseReqDto){
        testCaseService.save(testCaseReqDto);
        return ResponseEntity.ok().body("Ok");
    }
    @GetMapping
    public  ResponseEntity<List<TestCaseResDto>>findAll(){
        return ResponseEntity.ok(testCaseService.findAll());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<TestCaseResDto>findById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody TestCaseReqDto dto){
        testCaseService.updateById(id,dto);
        return ResponseEntity.ok().body("Ok");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        testCaseService.deleteById(id);
        return ResponseEntity.ok().body("Ok");
    }
    @GetMapping("/date")
    public ResponseEntity<List<TestCaseResDto>> findAfterDate(@RequestParam("last_update") String lastUpdate){
        return new ResponseEntity<>(testCaseService.findAfterDate(lastUpdate), HttpStatus.OK);

    }
}
