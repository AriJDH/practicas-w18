package com.example.qatesters.service;

import com.example.qatesters.dto.request.TestCaseRequest;
import com.example.qatesters.dto.response.TestCaseResponse;

import java.util.List;

public interface IServiceTestCase {

    TestCaseResponse createTestCase(TestCaseRequest testCase);

    TestCaseResponse getTestCaseById(Long id);

    List<TestCaseResponse> getAllTestCase(String lastUpdate);

    TestCaseResponse updateTestCase(Long id, TestCaseRequest testCase);

    void deleteTestCase(Long id);

}
