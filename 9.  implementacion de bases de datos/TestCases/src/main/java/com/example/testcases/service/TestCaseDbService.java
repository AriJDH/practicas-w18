package com.example.testcases.service;

import com.example.testcases.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseDbService {
    TestCase createTestCase(TestCase testCase);
    List<TestCase> findAllTestCases();
    TestCase findTestCaseById(Long id);
    TestCase updateTestCase(Long id, TestCase testCase);
    void deleteTestCase(Long id);
    List<TestCase> findAllTestCasesUpdatedAfterDate(LocalDate date);
}
