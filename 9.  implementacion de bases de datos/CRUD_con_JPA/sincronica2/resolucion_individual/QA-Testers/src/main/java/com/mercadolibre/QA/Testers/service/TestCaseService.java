package com.mercadolibre.QA.Testers.service;

import com.mercadolibre.QA.Testers.entity.TestCase;
import com.mercadolibre.QA.Testers.repository.iTestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements iTestCaseService {
    iTestCaseRepository testCaseRepository;

    @Autowired
    public TestCaseService(iTestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCase create(TestCase testCase) {
        testCaseRepository.save(testCase);
        return testCase;
    }

    @Override
    public TestCase findById(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public TestCase update(TestCase testCase, Long id) {
        TestCase testToUpdate = testCaseRepository.findById(id).orElse(null);
        if ( testToUpdate != null){
            testToUpdate.setDescription(testCase.getDescription());
            testToUpdate.setTested(testCase.getTested());
            testToUpdate.setPassed(testCase.getPassed());
            testToUpdate.setNumber_of_tries(testCase.getNumber_of_tries());
            testToUpdate.setLastUpdate(testToUpdate.getLastUpdate());
            testCaseRepository.save(testToUpdate);
        }
        return testCase;
    }

    @Override
    public void delete(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        assert testCase != null;
        testCaseRepository.delete(testCase);
    }

    @Override
    public List<TestCase> findAll() {
        return testCaseRepository.findAll();
    }

    @Override
    public List<TestCase> filterByLastUpdate(String last_update) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.parse(last_update, formatter);
        return testCaseRepository.findTestCaseByLastUpdate(localDate);
    }


}
