package com.example.testers.service;

import com.example.testers.dto.MessageDTO;
import com.example.testers.dto.request.DtoTestCaseRequest;
import com.example.testers.model.TestCase;

import java.util.List;

public interface ITestersCaseService {
    MessageDTO createTestCase(DtoTestCaseRequest testCaseRequest);

    List <TestCase> getAllTest();

    TestCase getTestById(Long id);

    MessageDTO upDateTest(Long id, DtoTestCaseRequest testCaseRequest);

    void deleteTest(Long id);

    List <TestCase> testByDate(String lastUpdate);
}
