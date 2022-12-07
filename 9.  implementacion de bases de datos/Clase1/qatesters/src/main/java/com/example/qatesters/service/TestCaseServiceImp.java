package com.example.qatesters.service;

import com.example.qatesters.dto.request.TestCaseDTOReq;
import com.example.qatesters.dto.response.GenericsDTORes;
import com.example.qatesters.dto.response.TestCaseDTORes;
import com.example.qatesters.exception.GenericException;
import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.ITestCaseRepository;
import com.example.qatesters.util.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImp implements ITestCaseService{
    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImp(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDTORes create(TestCaseDTOReq testCaseDTOReq) {
        TestCase testCase = Mapper.createObjectMapper().convertValue(testCaseDTOReq, TestCase.class);

        return Mapper.createObjectMapper().convertValue(testCaseRepository.save(testCase),TestCaseDTORes.class);
    }

    @Override
    public List<TestCaseDTORes> findAll() {
        List<TestCase> testCaseList = testCaseRepository.findAll();
        return testCaseList.stream().map(testCase -> Mapper.createObjectMapper().convertValue(testCase,TestCaseDTORes.class)).collect(Collectors.toList());
    }

    @Override
    public TestCaseDTORes findById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(()->new GenericException("Test no encontrado"));
        return Mapper.createObjectMapper().convertValue(testCase,TestCaseDTORes.class);
    }

    @Override
    public TestCaseDTORes updateById(Long id, TestCaseDTOReq testCaseDTOReq) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(()->new GenericException("Test no encontrado"));
        testCase.setDescription(testCaseDTOReq.getDescription());
        testCase.setTested(testCaseDTOReq.getTested());
        testCase.setPassed(testCaseDTOReq.getPassed());
        testCase.setNumber_of_tries(testCaseDTOReq.getNumber_of_tries());
        testCase.setLast_update(testCaseDTOReq.getLast_update());
        testCaseRepository.save(testCase);
        return Mapper.createObjectMapper().convertValue(testCase, TestCaseDTORes.class);
    }

    @Override
    public GenericsDTORes deleteById(Long id) {
        TestCase stored = testCaseRepository.findById(id).orElseThrow(()->new GenericException("Test no encontrado"));
        testCaseRepository.delete(stored);
        return new GenericsDTORes(200,"El TestCase "+id+" ha sido eliminado");
    }

    @Override
    public List<TestCaseDTORes> findByDate(LocalDate date) {
        List<TestCase> testCaseList = testCaseRepository.findAll().stream().filter(testCase -> testCase.getLast_update().isAfter(date)).collect(Collectors.toList());
        return testCaseList.stream().map(testCase -> Mapper.createObjectMapper().convertValue(testCase,TestCaseDTORes.class)).collect(Collectors.toList());
    }
}
