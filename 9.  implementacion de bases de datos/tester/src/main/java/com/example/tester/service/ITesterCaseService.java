package com.example.tester.service;

import com.example.tester.dto.response.TestCaseResponse;
import com.example.tester.model.entity.TestCase;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ITesterCaseService {
    public List<TestCase> getTesterCase();
    public TestCaseResponse saveTesterCase(TestCase testCase);
    public TestCaseResponse deleteTesterCase(Long idTestCase);
    public TestCase findTesterCase(Long idTestCase);
    public TestCaseResponse editTesterCase(Long idTestCase, TestCase testCase) throws JsonProcessingException;
}
