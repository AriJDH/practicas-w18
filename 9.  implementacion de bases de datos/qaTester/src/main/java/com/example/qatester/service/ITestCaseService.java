package com.example.qatester.service;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.TestCaseDtoReq;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITestCaseService {

    public List<TestCaseDto> getTestCaseDtos();
    public TestCaseDto getTestCaseById(Long id);
    public void saveTestCase(TestCaseDtoReq TestCaseDto);
    public void deleteTestCaseDto(Long id);
    public TestCaseDto findTestCaseDto(Long id);
    public TestCaseDto updateTestCaseDto(Long id, TestCaseDtoReq TestCaseDto);
    public List<TestCaseDto> getTestCaseByDate(String date);
}
