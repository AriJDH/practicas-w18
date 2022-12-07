package com.tester.tester.controller;

import com.tester.tester.dto.ResponseDTO;
import com.tester.tester.dto.TestCaseDTO;
import com.tester.tester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> create (@RequestBody TestCaseDTO test) {
        ResponseDTO creado = testCaseService.create(test);
        return ResponseEntity.status(creado.getStatus()).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getAll (){
        List<TestCaseDTO> tests = testCaseService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(tests);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById (@PathVariable long id){
        TestCaseDTO test = testCaseService.getById(id);
        if (test != null)
            return ResponseEntity.status(HttpStatus.OK).body(test);
        else {
            ResponseDTO response = new ResponseDTO(400, "El test que desea visualizar no existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update (@PathVariable Long id, @RequestBody TestCaseDTO test){
        ResponseDTO updateado = testCaseService.update(id,test);
        return ResponseEntity.status(updateado.getStatus()).body(updateado);
    }

}
