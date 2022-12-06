package com.qa.testcase.service;

import com.qa.testcase.dto.request.TestCaseRequest;
import com.qa.testcase.dto.response.TestCaseResponse;
import com.qa.testcase.entity.TestCase;

import java.util.List;

public interface ITestCaseService {
    TestCaseResponse saveTestCase(TestCaseRequest testCaseRequest);
    TestCaseResponse updateTestCase(long id, TestCaseRequest testCaseRequest);
    List<TestCase> getAllTestCase();
    TestCase findTestCase(long id);
    void deleteTestCase(long id);
    List<TestCase> getAllTestCaseUpdatedAfterDate(String lastUpdate);
}
