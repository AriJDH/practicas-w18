package com.example.testcase.service;

import com.example.testcase.dto.request.TestcaseDTOReq;
import com.example.testcase.dto.request.TestcaseIdDTOReq;
import com.example.testcase.dto.response.TestcaseDTORes;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface ITestcaseService {
    Long createTest(TestcaseDTOReq testcaseDTOReq);
    List<TestcaseDTORes> getAll();
    TestcaseDTORes getById(Long id);
    void update(TestcaseIdDTOReq testcaseDTOReq);
    void delete(Long id);
    List<TestcaseDTORes> getAllByLastUpdateAfter(LocalDate date);
}
