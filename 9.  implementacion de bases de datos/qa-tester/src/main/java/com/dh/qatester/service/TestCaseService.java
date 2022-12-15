package com.dh.qatester.service;

import com.dh.qatester.dto.TestCaseDtoReq;
import com.dh.qatester.dto.TestCaseDtoRes;
import com.dh.qatester.entity.TestCase;
import com.dh.qatester.repository.ITestCaseRepository;
import com.dh.qatester.util.HandlerDate;
import com.dh.qatester.util.MapToDto;
import com.dh.qatester.util.MapToEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public void createTestCase(TestCaseDtoReq testCaseDto) {
        TestCase testCase = MapToEntity.map(testCaseDto);

        testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCaseDtoRes> findAll() {
        return testCaseRepository
                .findAll()
                .stream()
                .map(MapToDto::map)
                .toList();
    }

    @Override
    public TestCaseDtoRes findById(Long id) {
        return testCaseRepository
                .findById(id)
                .map(MapToDto::map)
                .orElseThrow();
    }

    @Override
    public TestCaseDtoRes updateTestCase(Long id, TestCaseDtoReq testCaseDto) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow();
        TestCase updateTestCase = MapToEntity.map(testCaseDto);
        updateTestCase.setId_case(testCase.getId_case());
        testCaseRepository.save(updateTestCase);
        return MapToDto.map(updateTestCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.findById(id).orElseThrow();
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseDtoRes> findTestCaseByDate(String date) {
        LocalDate d = HandlerDate.StringToDate(date.replace("/", "-"));
        return testCaseRepository
                .findByLastUpdated_After(d)
                .stream()
                .map(MapToDto::map)
                .toList();
    }
}
