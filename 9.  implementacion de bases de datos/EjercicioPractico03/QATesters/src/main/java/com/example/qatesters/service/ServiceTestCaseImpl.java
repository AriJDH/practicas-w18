package com.example.qatesters.service;

import com.example.qatesters.dto.request.TestCaseRequest;
import com.example.qatesters.dto.response.TestCaseResponse;
import com.example.qatesters.entity.TestCaseEntity;
import com.example.qatesters.repository.TestCaseRepository;
import com.example.qatesters.util.mapper.TestCaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceTestCaseImpl implements IServiceTestCase {

    private final TestCaseRepository testCaseRepository;

    @Override
    public TestCaseResponse createTestCase(TestCaseRequest testCase) {

        TestCaseEntity entity = testCaseRepository.save(TestCaseMapper.request2entity(testCase));
        return TestCaseMapper.entity2Response(entity);
    }

    @Override
    public TestCaseResponse getTestCaseById(Long id) {

        if (testCaseRepository.existsById(id)) {
            return TestCaseMapper.entity2Response(testCaseRepository.findById(id).get());
        } else {
            throw new RuntimeException("El Test con ID: " + id + "no existe !");
        }
    }

    @Override
    public List<TestCaseResponse> getAllTestCase(String lastUpdate) {

        List<TestCaseResponse> response = TestCaseMapper.entityList2ResponseList(testCaseRepository.findAll());
        if (lastUpdate != null){
            LocalDate date = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            response = response
                    .stream()
                    .filter(testCaseResponse -> testCaseResponse.getLastUpdate().isAfter(date))
                    .collect(Collectors.toList());
        }

        return response;
    }

    @Override
    public TestCaseResponse updateTestCase(Long id, TestCaseRequest testCase) {

        if (testCaseRepository.existsById(id)) {
            TestCaseEntity entity = TestCaseMapper.request2entity(testCase);
            entity.setId(id);

            return TestCaseMapper.entity2Response(testCaseRepository.save(entity));
        } else {
            throw new RuntimeException("El Test con ID: " + id + "no existe !");
        }
    }

    @Override
    public void deleteTestCase(Long id) {

        if (testCaseRepository.existsById(id)) {
            testCaseRepository.deleteById(id);
        }
    }

}
