package com.example.testcases.service;

import com.example.testcases.exception.EntityNotFoundException;
import com.example.testcases.model.TestCase;
import com.example.testcases.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.DateTimeFormatterFactoryBean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class TestCaseDbServiceImpl implements TestCaseDbService{
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Override
    public TestCase createTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCase> findAllTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase findTestCaseById(Long id) {
        return testCaseRepository.findById(id)
                .orElseThrow(()->{throw new EntityNotFoundException("El caso de test " + id + " no existe.");});
    }

    @Override
    public TestCase updateTestCase(Long id, TestCase testCase) {
        findTestCaseById(id);
        testCase.setId_case(id);
        return testCaseRepository.save(testCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        findTestCaseById(id);
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCase> findAllTestCasesUpdatedAfterDate(LocalDate date) {
        return testCaseRepository.findAllTestCasesUpdatedAfterDate(date);
    }

}
