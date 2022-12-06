package com.example.testcase.controller;

import com.example.testcase.dto.request.TestcaseDTOReq;
import com.example.testcase.dto.request.TestcaseIdDTOReq;
import com.example.testcase.dto.response.TestcaseDTORes;
import com.example.testcase.service.ITestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestcaseController {

    @Autowired
    private ITestcaseService testcaseService;

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody TestcaseDTOReq testcase){
        Long id = testcaseService.createTest(testcase);
        return new ResponseEntity<>("Se ha creado el testcase "+id, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TestcaseDTORes>> getAll(){
        return new ResponseEntity<>(testcaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestcaseDTORes> getById(@PathVariable Long id){
        return new ResponseEntity<>(testcaseService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody TestcaseIdDTOReq testcase){
        testcase.setIdCase(id);
        testcaseService.update(testcase);
        return new ResponseEntity<>("Se actualizo el testcase con id "+id, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delById(@PathVariable Long id){
        testcaseService.delete(id);
        return new ResponseEntity<>("Se borro exitosamente el testcase con id " + id, HttpStatus.ACCEPTED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestcaseDTORes>> getAllByLastUpdateAfter(@RequestParam String last_update){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDate localDate = LocalDate.parse(last_update, formatter);
        return new ResponseEntity<>(testcaseService.getAllByLastUpdateAfter(localDate), HttpStatus.OK);
    }
}
