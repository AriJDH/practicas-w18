package com.bootcamp.qatester.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.bootcamp.qatester.dto.request.TestCaseDtoRequest;
import com.bootcamp.qatester.dto.response.TestCaseDtoReponseStatusMessage;
import com.bootcamp.qatester.dto.response.TestCaseDtoResponse;
import com.bootcamp.qatester.entity.TestCase;
import com.bootcamp.qatester.repository.ITestCaseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService{

    private final ITestCaseRepository testCaseRepository;
    private final ObjectMapper objectMapper;
    @Override
    public List<TestCaseDtoResponse> findAll() {
        return objectMapper.convertValue(testCaseRepository.findAll(), new TypeReference<List<TestCaseDtoResponse>>() {});

    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseDtoResponse findById(Long id) {
        TestCaseDtoResponse testCaseDtoResponse = null;
        if (testCaseRepository.existsById(id)) {
            TestCase testCase = testCaseRepository.findById(id).get();
            testCaseDtoResponse = objectMapper.convertValue(testCase, TestCaseDtoResponse.class);
        }
        return testCaseDtoResponse;
    }

    @Override
    @Transactional
    public TestCaseDtoReponseStatusMessage save(TestCaseDtoRequest testCase) {
        TestCase testsCase = objectMapper.convertValue(testCase, TestCase.class);
        TestCase savedTestCase = testCaseRepository.save(testsCase);
        testCase.setLastUpdate(LocalDate.now());
        return new TestCaseDtoReponseStatusMessage(201,"Se creo el test");
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseDtoReponseStatusMessage update(Long id, TestCaseDtoRequest testCase) {
        if(testCaseRepository.existsById(id)){
            TestCase updatedTestCase = testCaseRepository.findById(id).get();
            updatedTestCase.setTested(testCase.getTested());
            updatedTestCase.setLastUpdate(LocalDate.now());
            updatedTestCase.setNumberOfTries(testCase.getNumberOfTries());
            updatedTestCase.setDescription(testCase.getDescription());
            updatedTestCase.setPassed(testCase.getPassed());
            testCaseRepository.save(updatedTestCase);
            return new TestCaseDtoReponseStatusMessage(200, "Se actualizo de manera correcta");
        }else{
            return new TestCaseDtoReponseStatusMessage(404,"No existe el id");
        }
    }

    @Override
    public TestCaseDtoReponseStatusMessage delete(Long id) {
        if(testCaseRepository.existsById(id)){
            TestCase testCase = testCaseRepository.findById(id).get();
            testCaseRepository.deleteById(id);
            return new TestCaseDtoReponseStatusMessage(200, "Se elimino correctamente");

        }else{
            return new TestCaseDtoReponseStatusMessage(404,"No existe el idTest");
        }
    }

    @Override
    public List<TestCaseDtoResponse> findAllByLastUpdateAfter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateParsed = LocalDate.parse(date, formatter);
        return objectMapper.convertValue(testCaseRepository.findAllByLastUpdateAfter(dateParsed), new TypeReference<List<TestCaseDtoResponse>>() {});
    }
}
