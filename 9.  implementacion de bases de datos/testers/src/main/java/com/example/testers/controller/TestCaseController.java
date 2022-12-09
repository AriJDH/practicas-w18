package com.example.testers.controller;

import com.example.testers.dto.MessageDTO;
import com.example.testers.dto.request.DtoTestCaseRequest;
import com.example.testers.model.TestCase;
import com.example.testers.service.TestersCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private TestersCaseService service;

    //Crear un nuevo caso de prueba.

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createTest (@RequestBody DtoTestCaseRequest testCaseRequest){
        return new ResponseEntity<>(service.createTestCase(testCaseRequest), HttpStatus.OK);
    }

    //Devolver todos los casos de prueba.
    @GetMapping
    public ResponseEntity<List<TestCase>> getAllTest(){
        return new ResponseEntity<>(service.getAllTest(), HttpStatus.OK);
    }

    //Devolver un caso de prueba por id
    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestById(@PathVariable Long id){
        return new ResponseEntity<>(service.getTestById(id),HttpStatus.OK);
    }

    //Actualizar un caso de prueba por id.

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateTest(@PathVariable Long id, @RequestBody DtoTestCaseRequest testCaseRequest){
        return new ResponseEntity<>(service.upDateTest(id, testCaseRequest), HttpStatus.OK);
    }
    //Eliminar un caso de prueba por id.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id){
        service.deleteTest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.
    @GetMapping("/date")
    public ResponseEntity<List<TestCase>> testByDate(@RequestParam("last_update") String lastUpdate){
        return new ResponseEntity<>(service.testByDate(lastUpdate),HttpStatus.OK);
    }
}
