package com.meli.envivotestcase.controller;

import com.meli.envivotestcase.model.TestCase;
import com.meli.envivotestcase.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class controller {

    @Autowired
    ITestCaseService iTestCaseService;

    @PostMapping("/new")
    public void postTestCase(@RequestBody TestCase testCase){
        iTestCaseService.newTestCase(testCase);
    }

    @GetMapping()
    public List<TestCase> getAllTestCase(){
        return iTestCaseService.getAllTestCase();
    }

    @GetMapping("/id")
    public TestCase getTestCaseById(Long id){
        return iTestCaseService.getTestCaseById(id);
    }

    @PutMapping("/id")
    public void putTestCaseById(@PathVariable Long id,@RequestBody TestCase testCase){
         iTestCaseService.updateTestCaseById(id,testCase);
    }

    @DeleteMapping("/id")
    public void deleteTestCaseById(@PathVariable Long id){
        iTestCaseService.deleteTestCaseById(id);
    }

    @GetMapping("/perDate")
    public List<TestCase> getAllByAfterLastUpdate(@RequestParam("last_update") String lastUpdate){
        LocalDate lastUpdateConverter = LocalDate.parse(lastUpdate);
        return iTestCaseService.getTestCaseByDate(lastUpdateConverter);
    }
}
