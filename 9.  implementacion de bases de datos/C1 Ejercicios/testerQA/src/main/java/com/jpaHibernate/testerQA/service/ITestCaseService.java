package com.jpaHibernate.testerQA.service;

import com.jpaHibernate.testerQA.dto.MessageDTOResponse;
import com.jpaHibernate.testerQA.dto.TestCaseDTO;
import com.jpaHibernate.testerQA.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public List<TestCase> getAll();
    public TestCase save(TestCase testCase);
    public MessageDTOResponse delete (Long id);
    public TestCase findById(Long id);

    public List<TestCase> findAfterDate(LocalDate date);

    TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO);
}
