package com.meli.envivotestcase.service;

import com.meli.envivotestcase.model.TestCase;
import com.meli.envivotestcase.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TestCaseServiceImp implements ITestCaseService {

    @Autowired
    private ITestCaseRepository iTestCaseRepository;


    @Override
    public void newTestCase(TestCase testCase) {
        testCase.setLastUpdate(LocalDate.now());
        iTestCaseRepository.save(testCase);
    }

    @Override
    public List<TestCase> getAllTestCase() {
        return iTestCaseRepository.findAll();
    }

    @Override
    public TestCase getTestCaseById(Long id) {
        return iTestCaseRepository.findById(id).orElse(null);
    }

    @Override
    public void updateTestCaseById(Long id,TestCase testCase) {
        TestCase testCaseUpdate = iTestCaseRepository.findById(id).orElse(null);
        testCaseUpdate.setDescription(testCase.getDescription());
        testCaseUpdate.setTested(testCase.getTested());
        testCaseUpdate.setPassed(testCase.getPassed());
        testCaseUpdate.setNumberOfTries(testCase.getNumberOfTries());
        testCaseUpdate.setLastUpdate(LocalDate.now());
        iTestCaseRepository.save(testCaseUpdate);
    }

    @Override
    public void deleteTestCaseById(Long id) {
        TestCase testCaseDelete = iTestCaseRepository.findById(id).orElse(null);
        iTestCaseRepository.delete(testCaseDelete);
    }

    @Override
    public List<TestCase> getTestCaseByDate(LocalDate lastUpdate) {
        return iTestCaseRepository.findAllByAfterLastUpdate(lastUpdate);
    }
}
