package com.example.qatester.service;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.TestCaseDtoReq;
import com.example.qatester.exception.BadRequestException;
import com.example.qatester.model.TestCase;
import com.example.qatester.repository.ITestCaseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImp implements ITestCaseService{

    private final ITestCaseRepository testCaseRepo;
    private final ObjectMapper mapper;


    public TestCaseServiceImp (ITestCaseRepository repo, ObjectMapper mapper){
        this.testCaseRepo=repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDto> getTestCaseDtos() {
        List<TestCase> list = testCaseRepo.findAll();
        return mapper.convertValue(list, new TypeReference<List<TestCaseDto>>() {});
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        return findTestCaseDto(id);
    }

    @Override
    @Transactional
    public void saveTestCase(TestCaseDtoReq testCaseDto) {
        TestCase test = mapper.convertValue(testCaseDto,TestCase.class);
        test.setLast_update(LocalDate.now());
        testCaseRepo.save(test);
    }

    @Override
    @Transactional
    public void deleteTestCaseDto(Long id) {
        testCaseRepo.deleteById(id);

    }

    @Override
    @Transactional (readOnly = true)
    public TestCaseDto findTestCaseDto(Long id) {
        TestCase test = testCaseRepo.findById(id).orElse(null);
        return mapper.convertValue(test,TestCaseDto.class);
    }

    @Override
    public TestCaseDto updateTestCaseDto(Long id, TestCaseDtoReq t) {
        TestCaseDto j = findTestCaseDto(id);
        j.setDescription(t.getDescription());
        j.setTested(t.getTested());
        j.setPassed(t.getPassed());
        j.setLast_update(LocalDate.now());
        saveTestCase(mapper.convertValue(j,TestCaseDtoReq.class));
        return j;
    }

    @Override
    public List<TestCaseDto> getTestCaseByDate(String date) {
       try {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           LocalDate d = LocalDate.parse(date,formatter);

           List<TestCase> list = testCaseRepo.findAll().stream().filter(t->t.getLast_update().isAfter(d)).collect(Collectors.toList());
           return mapper.convertValue(list, new TypeReference<List<TestCaseDto>>() {});

       }
       catch (Exception e){
           throw new BadRequestException("Format date invalid, use dd-mm-yyyy");
       }
    }
}
