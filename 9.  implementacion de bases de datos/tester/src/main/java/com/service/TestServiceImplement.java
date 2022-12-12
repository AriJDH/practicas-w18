package com.service;

import com.dto.request.TestRequestDTO;
import com.dto.response.ResponseDTO;
import com.dto.response.TestResponseDTO;
import com.dto.response.TestsResponseDTO;
import com.exception.NoFoundException;
import com.model.Test;
import com.repository.ITestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestServiceImplement implements ITestService {

    private ITestRepository iTestRepository;

    public TestServiceImplement(ITestRepository iTestRepository) {
        this.iTestRepository = iTestRepository;
    }

    @Override
    public ResponseDTO create(TestRequestDTO request) {
        Test test = new Test();

        test.setTested(request.getTested());
        test.setDescription(request.getDescription());
        test.setPassed(request.getPassed());
        test.setNumberOfTries(request.getNumberOfTries());
        test.setLastUpdate(request.getLastUpdate());

        iTestRepository.save(test);

        return new ResponseDTO("Test was saved", 201);
    }

    @Override
    public TestsResponseDTO getTests(String lastUpdate) {
        List<Test> tests;

        if (lastUpdate != null) {
            tests = iTestRepository.findTestByDate(lastUpdate);
        } else {
            tests = iTestRepository.findAll();
        }

        return new TestsResponseDTO(tests);
    }

    @Override
    public TestResponseDTO get(Long id) {
        Test test = iTestRepository.findById(id).orElse(null);

        if (test == null) throw new NoFoundException("Test not found");

        return new TestResponseDTO(test.getIdCase(), test.getDescription(), test.getTested(), test.getPassed(), test.getNumberOfTries(), test.getLastUpdate());
    }

    @Override
    public ResponseDTO update(Long id, TestRequestDTO request) {

        Test test = iTestRepository.findById(id).orElse(null);
        if (test == null) throw new NoFoundException("Test not found");
        test.setTested(request.getTested());
        test.setDescription(request.getDescription());
        test.setPassed(request.getPassed());
        test.setNumberOfTries(request.getNumberOfTries());
        test.setLastUpdate(LocalDate.now());

        iTestRepository.save(test);

        return new ResponseDTO("Test was updated", 200);
    }

    @Override
    public ResponseDTO delete(Long id) {

        Test test = iTestRepository.findById(id).orElse(null);
        if (test == null) throw new NoFoundException("Test not found");

        iTestRepository.deleteById(id);

        return new ResponseDTO("Test was deleted", 200);
    }
}
