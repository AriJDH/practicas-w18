package com.example.testcase.service.imp;

import com.example.testcase.dto.request.TestCaseDTORequest;
import com.example.testcase.dto.response.TestCaseDTOResponse;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public void newTestCase(TestCaseDTORequest testCaseDTORequest);
    public List<TestCaseDTOResponse> getTestCases();
    public TestCaseDTOResponse getTestCaseById(Long id);
    public void updateTestCase(TestCaseDTORequest testCaseDTORequest, Long id);
    public void deleteTestCase(Long id);
    public List<TestCaseDTOResponse> getByLastUpdate(LocalDate date);
}
