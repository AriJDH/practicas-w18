package com.example.testers.service;

import com.example.testers.dto.MessageDTO;
import com.example.testers.dto.request.DtoTestCaseRequest;
import com.example.testers.model.TestCase;
import com.example.testers.repository.ITestersCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestersCaseService implements ITestersCaseService {

    private final ModelMapper mapper;
    @Autowired
    private ITestersCaseRepository repository;

    public TestersCaseService() {
        this.mapper = new ModelMapper();
    }

    @Override
    public MessageDTO createTestCase(DtoTestCaseRequest testCaseRequest) {
        TestCase testCase = repository.save(mapper.map(testCaseRequest, TestCase.class));
        return new MessageDTO("Alta exitosa. Nro ID: " + testCase.getIdCase());
    }

    @Override
    public List<TestCase> getAllTest() {
        List<TestCase> result = repository.findAll();
        return result;
    }

    @Override
    public TestCase getTestById(Long id) {
        TestCase testCase = repository.findById(id).orElse(null);
        return testCase;
    }

    @Override
    public MessageDTO upDateTest(Long id, DtoTestCaseRequest testCase) {
        TestCase testCaseUpdate;
        if (getTestById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("ID: %s no existe.", id));
        } else {
            testCaseUpdate = repository.save(mapper.map(testCase, TestCase.class));
        }
        return new MessageDTO("Modificacion exitosa. Nro ID: " + testCaseUpdate.getIdCase());
    }

    @Override
    public void deleteTest(Long id) {
        TestCase testCaseUpdate;
        if (getTestById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("ID: %s no existe.", id));
        } else {
            repository.deleteById(id);
        }
    }

    @Override
    public List<TestCase> testByDate(String lastUpdate) {
        LocalDate localDateNew = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<TestCase> testCases = repository.findAll().stream()
                .filter(testCase -> testCase.getLastUpdate().isAfter(localDateNew))
                .collect(Collectors.toList());

        return testCases;
    }
}
