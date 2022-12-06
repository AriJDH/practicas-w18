package com.dh.qatester.service;

import com.dh.qatester.dto.TestCaseDtoReq;
import com.dh.qatester.dto.TestCaseDtoRes;

import java.util.List;

public interface ITestCaseService {

    void createTestCase(TestCaseDtoReq testCaseDto);

    List<TestCaseDtoRes> findAll();

    TestCaseDtoRes findById(Long id);

    TestCaseDtoRes updateTestCase(Long id, TestCaseDtoReq testCaseDto);

    void deleteTestCase(Long id);

    List<TestCaseDtoRes> findTestCaseByDate(String date);

}
