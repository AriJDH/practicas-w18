package com.example.qatesters.service;


import com.example.qatesters.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestService {
    TestCase createTestCase(TestCase t);
    TestCase updateTestCase(Long id, TestCase t);
    List<TestCase> getAllTestCases();
    TestCase getTestCaseById(Long id);
    List<TestCase> getTestCasesByQuery(String last_update);
    void deleteTestCaseById(Long id);
}
