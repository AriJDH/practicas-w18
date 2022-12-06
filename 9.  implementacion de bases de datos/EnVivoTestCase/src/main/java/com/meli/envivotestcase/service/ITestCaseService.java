package com.meli.envivotestcase.service;

import com.meli.envivotestcase.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void newTestCase(TestCase testCase);
    List<TestCase> getAllTestCase();
    TestCase getTestCaseById(Long id);
    void updateTestCaseById(Long id,TestCase testCase);
    void deleteTestCaseById(Long id);
    List<TestCase> getTestCaseByDate(LocalDate lastUpdate);
}
