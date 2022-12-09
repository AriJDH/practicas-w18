package com.bootcamp.QATester.service;

import com.bootcamp.QATester.dto.req.TestCaseReqDto;
import com.bootcamp.QATester.dto.views.TestCaseResDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService  {
    List<TestCaseResDto>findAll();
    void save(TestCaseReqDto testCaseReqDto);
    TestCaseResDto findById(Long id);
    void updateById(Long id,TestCaseReqDto dto);
    void deleteById(Long id);
    List<TestCaseResDto> findAfterDate(String date);
}
