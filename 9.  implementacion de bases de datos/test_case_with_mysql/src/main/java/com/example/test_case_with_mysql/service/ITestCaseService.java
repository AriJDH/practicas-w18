package com.example.test_case_with_mysql.service;

import com.example.test_case_with_mysql.dto.CreateTestCaseDTO;
import com.example.test_case_with_mysql.dto.ResultadoDTO;
import com.example.test_case_with_mysql.dto.SearchTestDTO;
import com.example.test_case_with_mysql.dto.TestDTO;

public interface ITestCaseService {

    ResultadoDTO createTest(CreateTestCaseDTO createTestCaseDTO);

    ResultadoDTO updateTest(Long id);

    SearchTestDTO getTests();

    TestDTO getTest(Long id);

    ResultadoDTO deleteTest(Long id);

    SearchTestDTO getTestsToDate(String fecha);
}
