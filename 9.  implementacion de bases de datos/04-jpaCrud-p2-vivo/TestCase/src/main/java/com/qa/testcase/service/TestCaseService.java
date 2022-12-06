package com.qa.testcase.service;

import com.qa.testcase.dto.request.TestCaseRequest;
import com.qa.testcase.dto.response.TestCaseResponse;
import com.qa.testcase.entity.TestCase;
import com.qa.testcase.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestCaseService implements ITestCaseService {

    private final ModelMapper modelMapper;
    private final ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public TestCaseResponse saveTestCase(TestCaseRequest testCaseRequest) {
        TestCase testCase = modelMapper.map(testCaseRequest, TestCase.class);
        testCase.setLastUpdate(LocalDate.now());
        return modelMapper.map(testCaseRepository.save(testCase), TestCaseResponse.class);
    }

    @Override
    public TestCaseResponse updateTestCase(long id, TestCaseRequest testCaseRequest) {
        TestCase testCaseUpdated = findTestCase(id);
        testCaseUpdated.setDescription(testCaseRequest.getDescription());
        testCaseUpdated.setTested(testCaseRequest.getTested());
        testCaseUpdated.setPassed(testCaseRequest.getPassed());
        testCaseUpdated.setNumberOfTries(testCaseRequest.getNumberOfTries());
        testCaseUpdated.setLastUpdate(LocalDate.now());
        return modelMapper.map(testCaseRepository.save(testCaseUpdated), TestCaseResponse.class);
    }

    @Override
    public List<TestCase> getAllTestCase() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase findTestCase(long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTestCase(long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCase> getAllTestCaseUpdatedAfterDate(String lastUpdate) {
        LocalDate localDate = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return testCaseRepository.findAll().stream()
                .filter(testCase -> testCase.getLastUpdate().isAfter(localDate))
                .collect(Collectors.toList());
    }
}