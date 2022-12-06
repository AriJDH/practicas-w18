package com.example.test_case_with_mysql.service;

import com.example.test_case_with_mysql.dto.CreateTestCaseDTO;
import com.example.test_case_with_mysql.dto.ResultadoDTO;
import com.example.test_case_with_mysql.dto.SearchTestDTO;
import com.example.test_case_with_mysql.dto.TestDTO;
import com.example.test_case_with_mysql.entity.TestCase;
import com.example.test_case_with_mysql.repository.ITestCaseRepository;
import com.example.test_case_with_mysql.utils.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public ResultadoDTO createTest(CreateTestCaseDTO createTestCaseDTO) {

        TestCase testCase = new TestCase();
        testCase.setTested(createTestCaseDTO.getTested());
        testCase.setPassed(createTestCaseDTO.getPassed());
        testCase.setDescription(createTestCaseDTO.getDescription());
        testCase.setNumber_of_tries(createTestCaseDTO.getNumber_of_tries());

        testCaseRepository.save(testCase);

        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setMessage("Create success");
        resultadoDTO.setStatus(HttpStatus.OK.value());

        return resultadoDTO;
    }

    @Override
    public ResultadoDTO updateTest(Long id) {

        Optional<TestCase> testCaseOptional = this.testCaseRepository.findById(id);

        if (testCaseOptional.isEmpty()) {
            return new ResultadoDTO("Not found", HttpStatus.NOT_FOUND.value());
        }

        TestCase testCase = testCaseOptional.get();

        testCase.setLast_update(LocalDate.now());

        this.testCaseRepository.save(testCase);

        return new ResultadoDTO("Update success", HttpStatus.OK.value());
    }

    @Override
    public SearchTestDTO getTests() {

        List<TestCase> testCaseList = this.testCaseRepository.findAll();

        List<TestDTO> testDTOs = testCaseList.stream()
                .map(x -> new TestDTO(x.getId_case(), x.getDescription(), x.getTested(),
                        x.getPassed(), x.getNumber_of_tries(), x.getLast_update()))
                .collect(Collectors.toList());

        return new SearchTestDTO(testDTOs);
    }

    @Override
    public TestDTO getTest(Long id) {

        Optional<TestCase> testCaseOptional = this.testCaseRepository.findById(id);

        if (testCaseOptional.isEmpty()) {
            return null;
        }

        TestCase testCase = testCaseOptional.get();

        return new TestDTO(testCase.getId_case(), testCase.getDescription(),
                testCase.getTested(), testCase.getPassed(), testCase.getNumber_of_tries(), testCase.getLast_update());
    }

    @Override
    public ResultadoDTO deleteTest(Long id) {

        Optional<TestCase> testCaseOptional = this.testCaseRepository.findById(id);

        if (testCaseOptional.isEmpty()) {
            return new ResultadoDTO("Not found", HttpStatus.NOT_FOUND.value());
        }

        TestCase testCase = testCaseOptional.get();

        this.testCaseRepository.delete(testCase);

        return new ResultadoDTO("Delete success", HttpStatus.OK.value());
    }

    @Override
    public SearchTestDTO getTestsToDate(String fecha) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(fecha, formatter);

        List<TestCase> testCases = this.testCaseRepository.findAll().stream()
                .filter(testCase -> testCase.getLast_update() != null
                        && testCase.getLast_update().isAfter(localDate)).collect(Collectors.toList());

        List<TestDTO> testDTOs = testCases.stream()
                .map(testCase -> Mapper.createObjectMapper().convertValue(testCase,TestDTO.class))
                .collect(Collectors.toList());

        return new SearchTestDTO(testDTOs);
    }
}
