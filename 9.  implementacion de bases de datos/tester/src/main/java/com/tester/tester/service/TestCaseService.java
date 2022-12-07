package com.tester.tester.service;

import com.tester.tester.dto.ResponseDTO;
import com.tester.tester.dto.TestCaseDTO;
import com.tester.tester.entity.TestCase;
import com.tester.tester.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements  ITestCaseService{
    @Autowired
    ITestCaseRepository testCaseRepository;

    @Override
    @Transactional
    public ResponseDTO create(TestCaseDTO testDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(testDTO.getLast_update(), formatter);

        TestCase test = new TestCase(testDTO.getDescription(), testDTO.getTested(), testDTO.getPassed(), testDTO.getNumber_of_tries(),date);
        TestCase resp = testCaseRepository.save(test);
        return new ResponseDTO(201, "Test " + resp.getId_case().toString() + " creado exitosamente");
    }

    @Override
    @Transactional
    public ResponseDTO delete(Long id) {
        if (testCaseRepository.existsById(id)){
            testCaseRepository.deleteById(id);
            return new ResponseDTO(200,"Test " + id + " eliminado con exito");
        }
        else{
            return new ResponseDTO(400,"El test que deséa eliminar no existe");
        }
    }

    @Override
    @Transactional
    public ResponseDTO update(Long id, TestCaseDTO testUpdate) {
        if (testCaseRepository.existsById(id)){
            TestCase test = testCaseRepository.findById(id).get();
            if (testUpdate.getLast_update() != null){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate date = LocalDate.parse(testUpdate.getLast_update(), formatter);
                test.setLast_update(date);
            }
            if (testUpdate.getTested() != null){
                test.setTested(testUpdate.getTested());
            }
            if (testUpdate.getDescription() != null){
                test.setDescription(testUpdate.getDescription());
            }
            if (testUpdate.getPassed() != null){
                test.setPassed(testUpdate.getPassed());
            }
            testCaseRepository.save(test);
            return new ResponseDTO(200,"El test " + test.getId_case() + " ha sido actualizado");
        }
        else {
            return new ResponseDTO(400,"El test que deséa actualizar no existe");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseDTO> getAll() {
        List<TestCase> tests = testCaseRepository.findAll();
        return tests.stream().map(p -> new TestCaseDTO(p.getDescription(),p.getTested(),p.getPassed(),p.getNumber_of_tries(),p.getLast_update().toString())).collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO getById(Long id) {
        if (testCaseRepository.existsById(id)){
            TestCase test = testCaseRepository.findById(id).get();
            return new TestCaseDTO(test.getDescription(), test.getTested(), test.getPassed(), test.getNumber_of_tries(), test.getLast_update().toString());
        }
        else{
            return null;
        }

    }
}
