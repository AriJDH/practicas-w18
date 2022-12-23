package com.example.qatester.service;

import com.example.qatester.dto.TestCaseRequestDTO;
import com.example.qatester.dto.TestCaseResponseDTO;

import java.util.List;

public interface ITestCaseService {
    // Guardar
    void saveAndFlush(TestCaseRequestDTO testCaseRequestDto);
    // Buscar Todos
    List<TestCaseResponseDTO> findAll();
    // Buscar por Id
    TestCaseResponseDTO findById(Long id);
    //buscar por description
    List<TestCaseResponseDTO> findByDescription(String description);
    // Eliminar por id
    void delete(Long id);
    // Modificar
    void update(Long id, TestCaseRequestDTO testCaseRequestDto);

}
