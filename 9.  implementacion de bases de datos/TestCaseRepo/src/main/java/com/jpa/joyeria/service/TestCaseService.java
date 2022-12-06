package com.jpa.joyeria.service;

import com.jpa.joyeria.model.TestCase;
import com.jpa.joyeria.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService {

    @Autowired
    private ITestCaseRepository repo;

    public TestCase save(TestCase testCase){
        return repo.save(testCase);
    }

    public TestCase update(TestCase testCase, Long id){

        if(getTestCase(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"TestCase no encontrado con id " + id);
        return repo.save(testCase);
    }

    public List<TestCase> getAll(){
        return repo.findAll();
    }
    public TestCase getTestCase(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.delete(getTestCase(id));
    }

    public List<TestCase> getByLastUpdate(String lastUpdate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(lastUpdate, formatter);

        return repo.findByLastUpdate(date);
    }
}
