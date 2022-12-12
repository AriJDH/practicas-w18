package com.controller;

import com.dto.request.TestRequestDTO;
import com.dto.response.ResponseDTO;
import com.dto.response.TestResponseDTO;
import com.dto.response.TestsResponseDTO;
import com.service.ITestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestController {

    private ITestService iTestService;

    public TestController(ITestService iTestService) {
        this.iTestService = iTestService;
    }

    @GetMapping("")
    public ResponseEntity<TestsResponseDTO> getTests(@RequestParam(required = false) String last_update){
        return new ResponseEntity<>(iTestService.getTests(last_update), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestResponseDTO> getTest(@PathVariable Long id){
        return new ResponseEntity<>(iTestService.get(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createTest(@RequestBody TestRequestDTO request){
        return new ResponseEntity<>(iTestService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateTest(@PathVariable Long id,@RequestBody TestRequestDTO request){
        return new ResponseEntity<>(iTestService.update(id,request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTest(@PathVariable Long id){
        return new ResponseEntity<>(iTestService.delete(id), HttpStatus.OK);
    }

}
