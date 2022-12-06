package com.meli.testcasesjpa.service;

import com.meli.testcasesjpa.model.request.TestCaseRequest;
import com.meli.testcasesjpa.model.response.TestCaseResponse;

import java.util.List;

public interface ITestCasesService {

    // ? ================ Methods ================ ?

    List<TestCaseResponse> findAll();
    TestCaseResponse findById(Long id);
    TestCaseResponse save(TestCaseRequest testCase);
    TestCaseRequest update(Long id, TestCaseResponse testCase);
    void delete(Long id);
    List<TestCaseResponse> findAllByLastUpdateAfter(String date);
}
