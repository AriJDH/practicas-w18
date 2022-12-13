package com.mercadolibre.QA.Testers.controller;

import com.mercadolibre.QA.Testers.entity.TestCase;
import com.mercadolibre.QA.Testers.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {
    TestCaseService testCaseService;

    @Autowired
    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/api/testcases/new")
    public TestCase create(@RequestBody TestCase newTest){
        return testCaseService.create(newTest);
    }

    @GetMapping("/api/testcases/all")
    public List<TestCase> findAll(){
        return testCaseService.findAll();
    }

    @GetMapping("/api/testcases/{id}")
    public TestCase findById(@PathVariable Long id){
        return testCaseService.findById(id);
    }

    @PutMapping("/api/testcases/{id}")
    public TestCase updateById(@RequestBody TestCase testUpdate, @PathVariable Long id){
        return testCaseService.update(testUpdate, id);
    }

    @DeleteMapping("/api/testcases/{id}")
    public void deleteById(@PathVariable Long id){
        testCaseService.delete(id);
    }

    @GetMapping("/api/testcases")
    public List<TestCase> filterLastUpdate (@RequestParam String date){
        return testCaseService.filterByLastUpdate(date);
    }

}
