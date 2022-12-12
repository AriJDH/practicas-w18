package com.jpaHibernate.testerQA.controller;

import com.jpaHibernate.testerQA.dto.MessageDTOResponse;
import com.jpaHibernate.testerQA.dto.TestCaseDTO;
import com.jpaHibernate.testerQA.model.TestCase;
import com.jpaHibernate.testerQA.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private final ITestCaseService testCaseService;


    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping()
    public List<TestCase> getAllTestCases(){
        return testCaseService.getAll();
    }

    @PostMapping()
    public ResponseEntity<TestCase> saveTestCase(@RequestBody TestCase testCase){
        TestCase tc = testCaseService.save(testCase);
        return ResponseEntity.status(HttpStatus.CREATED).body(tc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        TestCaseDTO testCaseDTOres = testCaseService.updateTestCase(id, testCaseDTO);
        return ResponseEntity.ok().body(testCaseDTOres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> findById(@PathVariable Long id){
        TestCase testCaseFinded = testCaseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(testCaseFinded);
    }

    @GetMapping("/last_update")
    public ResponseEntity<List<TestCase>> findTestCaseAfterDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
        return ResponseEntity.status(HttpStatus.FOUND).body(testCaseService.findAfterDate(date));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTOResponse> deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.IM_USED).body(testCaseService.delete(id));
    }



}
