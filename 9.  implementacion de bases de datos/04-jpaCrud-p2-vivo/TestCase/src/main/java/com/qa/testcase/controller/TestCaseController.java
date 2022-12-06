package com.qa.testcase.controller;

import com.qa.testcase.dto.request.TestCaseRequest;
import com.qa.testcase.dto.response.TestCaseResponse;
import com.qa.testcase.entity.TestCase;
import com.qa.testcase.service.ITestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    /**
     * Crear un nuevo caso de prueba.
     */
    @PostMapping("/new")
    public ResponseEntity<TestCaseResponse> createTestCase(@RequestBody TestCaseRequest testCaseRequest) {
        return new ResponseEntity<>(testCaseService.saveTestCase(testCaseRequest), HttpStatus.CREATED);
    }

    /**
     * Devolver todos los casos de prueba.
     */
    @GetMapping
    public ResponseEntity<List<TestCase>> getAllTestCase() {
        return new ResponseEntity<>(testCaseService.getAllTestCase(), HttpStatus.OK);
    }

    /**
     * Devolver un caso de prueba por id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getAllTestCase(@PathVariable long id) {
        return new ResponseEntity<>(testCaseService.findTestCase(id), HttpStatus.OK);
    }

    /**
     * Actualizar un caso de prueba por id.
     */
    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponse> updateTestCAse(@PathVariable long id, @RequestBody TestCaseRequest testCaseRequest) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseRequest), HttpStatus.OK);
    }

    /**
     * Eliminar un tutorial por id.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable long id) {
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>("Test case id" + id + " borrado!", HttpStatus.NO_CONTENT);
    }

    /**
     * Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.
     */
    @GetMapping("/date")
    public ResponseEntity<List<TestCase>> updateTestCAse(@RequestParam("last_update") String lastUpdate) {
        return new ResponseEntity<>(testCaseService.getAllTestCaseUpdatedAfterDate(lastUpdate), HttpStatus.OK);
    }

}
