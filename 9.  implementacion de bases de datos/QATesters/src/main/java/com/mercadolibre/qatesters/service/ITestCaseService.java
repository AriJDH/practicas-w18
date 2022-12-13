package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.dto.request.TestCaseRequest;
import com.mercadolibre.qatesters.dto.response.TestCaseResponse;
import com.mercadolibre.qatesters.entity.TestCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITestCaseService {
    TestCaseResponse saveTestCase(TestCaseRequest testCaseRequest);
    TestCaseResponse updateTestCase(long id, TestCaseRequest testCaseRequest);
    List<TestCase> getAllTestCase();
    TestCase findTestCase(long id);
    void deleteTestCase(long id);
    List<TestCase> getAllTestCaseUpdatedAfterDate(String lastUpdate);
}
