package com.example.qatesters.service;

import com.example.qatesters.entity.TestCase;
import com.example.qatesters.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImp implements ITestService{
    @Autowired
    ITestRepository testRepo;

    @Override
    public TestCase createTestCase(TestCase t) {
        return this.testRepo.save(t);
    }

    @Override
    public TestCase updateTestCase(Long id, TestCase testUpdate) {
        TestCase entity = this.testRepo.findById(id).orElse(null);
        if(entity == null)throw new IllegalArgumentException("El id ingresado no existe.");
        this.updateTestCase(entity, testUpdate);
        return this.testRepo.save(entity);
    }

    @Override
    public List<TestCase> getAllTestCases() {
        return this.testRepo.findAll();
    }

    @Override
    public TestCase getTestCaseById(Long id) {
        return this.testRepo.findById(id).orElse(null);
    }

    @Override
    public List<TestCase> getTestCasesByQuery(String last_update) {
        return this.testRepo.findByLastUpdated(LocalDate.parse(last_update)).orElse(new ArrayList<>());
    }

    @Override
    public void deleteTestCaseById(Long id) {
        this.testRepo.findById(id).orElseThrow(()->new IllegalArgumentException("El id no existe."));
        this.testRepo.deleteById(id);
    }

    private void updateTestCase(TestCase entity, TestCase update){
        entity.setDescription(update.getDescription());
        entity.setTested(update.isTested());
        entity.setPassed(update.isPassed());
        entity.setLast_update(update.getLast_update());
        entity.setNumber_of_tries(update.getNumber_of_tries());
    }
}
