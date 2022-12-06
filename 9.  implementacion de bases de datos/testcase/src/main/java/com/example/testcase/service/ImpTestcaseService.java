package com.example.testcase.service;


import com.example.testcase.dto.request.TestcaseDTOReq;
import com.example.testcase.dto.request.TestcaseIdDTOReq;
import com.example.testcase.dto.response.TestcaseDTORes;
import com.example.testcase.model.Testcase;
import com.example.testcase.repository.ITestcaseRepository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ImpTestcaseService implements ITestcaseService{

    @Autowired
    private ITestcaseRepository testcaseRepository;
    private ObjectMapper objectMapper = new ObjectMapper()
                                            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false)
                                            .findAndRegisterModules();


    @Override
    public Long createTest(TestcaseDTOReq testcaseDTOReq){
        Testcase testcase = objectMapper.convertValue(testcaseDTOReq, Testcase.class);
        testcaseRepository.save(testcase);
        return testcase.getIdCase();
    }

    @Override
    public List<TestcaseDTORes> getAll(){
        List<TestcaseDTORes> testCaseDTOResList = testcaseRepository.findAll().stream()
                                                    .map(testcase -> objectMapper.convertValue(testcase,TestcaseDTORes.class))
                                                    .collect(Collectors.toList());

        return testCaseDTOResList;
    }

    @Override
    public TestcaseDTORes getById(Long id){
        TestcaseDTORes testcaseDTORes = objectMapper.convertValue(testcaseRepository.findById(id), TestcaseDTORes.class);
        return testcaseDTORes;
    }

    @Override
    public void update(TestcaseIdDTOReq testcaseDTOReq){
        Testcase testcase = objectMapper.convertValue(testcaseDTOReq, Testcase.class);
        testcaseRepository.save(testcase);
    }

    @Override
    public void delete(Long id){
        testcaseRepository.deleteById(id);
    }

    @Override
    public List<TestcaseDTORes> getAllByLastUpdateAfter(LocalDate date){
        List<TestcaseDTORes> testcaseDTOResList = testcaseRepository.findAllByLastUpdateAfter(date).stream()
                                                                    .map(testcase -> objectMapper.convertValue(testcase,TestcaseDTORes.class))
                                                                    .collect(Collectors.toList());
        return testcaseDTOResList;
    }

}
