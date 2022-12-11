package com.example.tester.service;

import com.example.tester.dto.response.TestCaseResponse;
import com.example.tester.exceptions.BadRequestException;
import com.example.tester.exceptions.NotFoundException;
import com.example.tester.model.entity.TestCase;
import com.example.tester.repository.ITesterCaseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class TesterCaseService implements ITesterCaseService  {

    private final ITesterCaseRepository testerCaseRepository;
    private static ObjectWriter writer;

    public TesterCaseService(ITesterCaseRepository testCaseRespository) {
        this.testerCaseRepository = testCaseRespository;
    }

    @Override
    public List<TestCase> getTesterCase() {
        List<TestCase> testCaseList = this.testerCaseRepository.findAll();
        return testCaseList;
    }

    @Override
    public TestCaseResponse saveTesterCase(TestCase testCase) {
        try {
            this.testerCaseRepository.save(testCase);
        } catch (Exception e) {
            throw new BadRequestException("Something went wrong");
        }

        List<TestCase> testCaseList = this.testerCaseRepository.findAll();
        testCaseList.sort(Comparator.comparing(TestCase::getIdCase).reversed());
        TestCaseResponse testCaseSaveResponse = new TestCaseResponse();
        testCaseSaveResponse.setMessage("Save test case #: "+testCaseList.get(0).getIdCase());
        testCaseSaveResponse.setStatus(HttpStatus.OK);
        return testCaseSaveResponse;
    }

    @Override
    public TestCaseResponse deleteTesterCase(Long idTestCase) {
        TestCase testCase = this.testerCaseRepository.findById(idTestCase).orElseThrow(()-> new NotFoundException("Test case with id: "+idTestCase+ " Not found"));
        this.testerCaseRepository.deleteById(idTestCase);

        TestCaseResponse testCaseDeleteResponse = new TestCaseResponse();
        testCaseDeleteResponse.setMessage("delete test sussesfully");
        testCaseDeleteResponse.setStatus(HttpStatus.OK);

        return testCaseDeleteResponse;
    }

    @Override
    public TestCase findTesterCase(Long idTestCase) {
        TestCase testCase = this.testerCaseRepository.findById(idTestCase).orElseThrow(()-> new NotFoundException("Test case with id: "+idTestCase+ " Not found"));
        return testCase;
    }

    @Override
    public TestCaseResponse editTesterCase(Long idTestCase, TestCase testCase) throws JsonProcessingException {
        TestCase testCasetoEdit = this.testerCaseRepository.findById(idTestCase).orElseThrow(()-> new NotFoundException("Test case with id: "+idTestCase+ " Not found"));

        testCasetoEdit.setTested(testCase.getTested());
        testCasetoEdit.setDescription(testCase.getDescription());
        testCasetoEdit.setLastUpdate(LocalDate.now());
        testCasetoEdit.setPassed(testCase.getPassed());
        testCasetoEdit.setNumberOfTries(testCase.getNumberOfTries());

        this.testerCaseRepository.save(testCasetoEdit);

        String userJson = writer.writeValueAsString(testCasetoEdit);

        TestCaseResponse testCaseEditResponse = new TestCaseResponse();
        testCaseEditResponse.setMessage("edit test sussesfully"+ userJson);
        testCaseEditResponse.setStatus(HttpStatus.OK);

        return testCaseEditResponse;
    }
}
