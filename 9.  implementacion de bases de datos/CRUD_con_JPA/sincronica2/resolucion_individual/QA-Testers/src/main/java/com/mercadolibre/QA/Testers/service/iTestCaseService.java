package com.mercadolibre.QA.Testers.service;

import com.mercadolibre.QA.Testers.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface iTestCaseService {
    public TestCase create(TestCase testCase);
    TestCase findById (Long id);
    TestCase update (TestCase testCase, Long id);
    void delete (Long id);

    List<TestCase> findAll();
    List<TestCase> filterByLastUpdate(String date);

    //List<TestCase> filterByLastUpdate(String last_update);
}
