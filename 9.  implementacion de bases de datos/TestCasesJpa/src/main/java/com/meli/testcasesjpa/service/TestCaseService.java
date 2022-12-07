package com.meli.testcasesjpa.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.testcasesjpa.exceptions.BadRequestException;
import com.meli.testcasesjpa.exceptions.NotFoundException;
import com.meli.testcasesjpa.model.TestCase;
import com.meli.testcasesjpa.model.request.TestCaseRequest;
import com.meli.testcasesjpa.model.response.TestCaseResponse;
import com.meli.testcasesjpa.repository.ITestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCasesService{

    // ? ================ Attributes ================ ?

    private final ITestCaseRepository testCaseRepository;
    private final ObjectMapper objectMapper;

    // ? ================ Methods ================ ?

    @Override
    public List<TestCaseResponse> findAll() {
        return objectMapper.convertValue(testCaseRepository.findAll(), new TypeReference<List<TestCaseResponse>>() {});
    }

    // * ==========

    @Override
    public TestCaseResponse findById(Long id) {
        return objectMapper.convertValue(testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("TestCase with id %d not found", id))), TestCaseResponse.class);
    }

    // * ==========

    @Override
    public TestCaseResponse save(TestCaseRequest testCase) {
        TestCase testCaseToSave = objectMapper.convertValue(testCase, TestCase.class);
        TestCase savedTestCase = testCaseRepository.save(testCaseToSave);
        testCase.setLastUpdate(LocalDate.now());
        return objectMapper.convertValue(savedTestCase, TestCaseResponse.class);
    }

    // * ==========

    @Override
    public TestCaseRequest update(Long id, TestCaseResponse testCase) {

        TestCaseResponse testCaseToUpdate = findById(id);

        testCaseToUpdate.setTested(testCase.getTested());
        testCaseToUpdate.setLastUpdate(LocalDate.now());
        testCaseToUpdate.setNumberOfTries(testCase.getNumberOfTries());
        testCaseToUpdate.setDescription(testCase.getDescription());
        testCaseToUpdate.setPassed(testCase.getPassed());

        TestCase updatedTestCase = objectMapper.convertValue(testCaseToUpdate, TestCase.class);
        updatedTestCase.setIdCase(id);

        TestCase savedTestCase = testCaseRepository.save(updatedTestCase);

        return objectMapper.convertValue(savedTestCase, TestCaseRequest.class);

    }

    // * ==========

    @Override
    public void delete(Long id) {

        TestCaseResponse testCaseFind= findById(id);
        TestCase testCaseToDelete = objectMapper.convertValue(testCaseFind, TestCase.class);
        testCaseToDelete.setIdCase(id);

        testCaseRepository.delete(testCaseToDelete);

    }

    // * ==========

    @Override
    public List<TestCaseResponse> findAllByLastUpdateAfter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate dateParsed = LocalDate.parse(date, formatter);
            return objectMapper.convertValue(testCaseRepository.findAllByLastUpdateAfter(dateParsed), new TypeReference<List<TestCaseResponse>>() {});
        }catch (Exception e){
            throw new BadRequestException("Date format is not valid, please use dd/MM/yyyy");
        }
    }


}
