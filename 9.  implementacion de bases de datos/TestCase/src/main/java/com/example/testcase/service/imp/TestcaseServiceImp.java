package com.example.testcase.service.imp;

import com.example.testcase.dto.request.TestCaseDTORequest;
import com.example.testcase.dto.response.TestCaseDTOResponse;
import com.example.testcase.entity.TestCase;
import com.example.testcase.exception.NotFoundException;
import com.example.testcase.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestcaseServiceImp implements ITestCaseService {
    private final ITestCaseRepository repoTestCase;

    private static final ObjectMapper op = new ObjectMapper();

    public TestcaseServiceImp(ITestCaseRepository repoTestCase) {
        this.repoTestCase = repoTestCase;
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public void newTestCase(TestCaseDTORequest testCaseDTORequest) {
        repoTestCase.save(op.convertValue(testCaseDTORequest, TestCase.class));
    }

    @Override
    public List<TestCaseDTOResponse> getTestCases() {
        return repoTestCase
                .findAll()
                .stream()
                .map(x-> op.convertValue(x, TestCaseDTOResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDTOResponse getTestCaseById(Long id) {
        TestCase testCase = repoTestCase.findById(id).orElse(null);
        if(testCase == null) throw new NotFoundException("Test not found");
        return op.convertValue(testCase, TestCaseDTOResponse.class);
    }

    @Override
    public void updateTestCase(TestCaseDTORequest testCaseDTORequest, Long id) {
        TestCase testCase = repoTestCase.findById(id).orElse(null);
        if (testCase == null) throw new NotFoundException("Test not found");
        testCase.setTested(testCaseDTORequest.getTested());
        testCase.setDescription(testCaseDTORequest.getDescription());
        testCase.setPassed(testCaseDTORequest.getPassed());
        testCase.setLast_update(testCaseDTORequest.getLast_update());
        testCase.setNumber_of_tries(testCaseDTORequest.getNumber_of_tries());
        repoTestCase.save(testCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        TestCase testCase = repoTestCase.findById(id).orElse(null);
        if(testCase == null) throw new NotFoundException("Test not found");
        repoTestCase.delete(testCase);
    }

    @Override
    public List<TestCaseDTOResponse> getByLastUpdate(LocalDate date) {
        return repoTestCase
                .findAll()
                .stream()
                .filter(x-> x.getLast_update().isAfter(date))
                .map(x-> op.convertValue(x, TestCaseDTOResponse.class))
                .collect(Collectors.toList());
    }
}
