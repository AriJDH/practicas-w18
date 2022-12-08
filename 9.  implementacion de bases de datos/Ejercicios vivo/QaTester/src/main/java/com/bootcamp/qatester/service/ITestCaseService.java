package com.bootcamp.qatester.service;

import java.util.List;

import com.bootcamp.qatester.dto.request.TestCaseDtoRequest;
import com.bootcamp.qatester.dto.response.TestCaseDtoReponseStatusMessage;
import com.bootcamp.qatester.dto.response.TestCaseDtoResponse;

public interface ITestCaseService {
    List<TestCaseDtoResponse> findAll();
    TestCaseDtoResponse findById(Long id);
    TestCaseDtoReponseStatusMessage save(TestCaseDtoRequest testCase);
    TestCaseDtoReponseStatusMessage update(Long id, TestCaseDtoRequest testCase);
    TestCaseDtoReponseStatusMessage delete(Long id);
    List<TestCaseDtoResponse> findAllByLastUpdateAfter(String date);

}
