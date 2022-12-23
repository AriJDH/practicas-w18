package com.example.qatester.service;

import com.example.qatester.dto.TestCaseRequestDTO;
import com.example.qatester.dto.TestCaseResponseDTO;
import com.example.qatester.model.TestCase;
import com.example.qatester.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestCaseServiceImp implements ITestCaseService{

    final
    ITestCaseRepository testCaseRepository;
    final
    ObjectMapper mapper;

    public TestCaseServiceImp(ITestCaseRepository testCaseRepository, ObjectMapper mapper) {
        this.testCaseRepository = testCaseRepository;
        this.mapper = mapper
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                        false);
    }
    @Override
    public void saveAndFlush(TestCaseRequestDTO testCaseRequestDTO) {
        /*TestCase testCase = new TestCase();
        testCase.setDescription(testCaseRequestDTO.getDescription());
        testCase.setTested(testCaseRequestDTO.isTested());
        testCase.setPased(testCaseRequestDTO.isPased());
        testCase.setNumber_of_tries(testCaseRequestDTO.getNumber_of_tries());
        testCase.setLast_update(testCaseRequestDTO.getLast_update());*/
        testCaseRepository.saveAndFlush(mapper.convertValue(testCaseRequestDTO, TestCase.class));

    }

    @Override
    public List<TestCaseResponseDTO> findAll() {
        return null;
    }

    @Override
    public TestCaseResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<TestCaseResponseDTO> findByDescription(String description) {
        List<TestCaseResponseDTO> testCasesResponseDTO = new ArrayList<>();
        testCaseRepository.findDescription(description).stream().forEach(
                TestCase -> testCasesResponseDTO.add(
                        new TestCaseResponseDTO(
                            TestCase.getId_case(), TestCase.getDescription(),
                            TestCase.isTested(),
                            TestCase.isPased(), TestCase.getNumber_of_tries(),
                            TestCase.getLast_update()
                ))
        );
        return testCasesResponseDTO;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, TestCaseRequestDTO testCaseRequestDto) {

    }
}
