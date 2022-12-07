package com.example.qatesters.service;

import com.example.qatesters.dto.request.TestCaseDTOReq;
import com.example.qatesters.dto.response.GenericsDTORes;
import com.example.qatesters.dto.response.TestCaseDTORes;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    TestCaseDTORes create(TestCaseDTOReq testCaseDTOReq);

    List<TestCaseDTORes> findAll();

    TestCaseDTORes findById(Long id);

    TestCaseDTORes updateById(Long id,TestCaseDTOReq testCaseDTOReq);

    abstract GenericsDTORes deleteById(Long id);

    List<TestCaseDTORes> findByDate(LocalDate date);


}
