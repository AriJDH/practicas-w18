package com.PasoPasoEjerciciosVivo.QATesters.service;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseRequestDto;
import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseResponseDto;

import java.util.List;

public interface ITestCaseService {
	
	// Guardar
	void saveAndFlush(TestCaseRequestDto testCaseRequestDto);
	// Buscar Todos
	List<TestCaseResponseDto> findAll();
	// Buscar por Id
	TestCaseResponseDto findById(Long id);
	// Eliminar por id
	void delete(Long id);
	// Modificar
	void update(Long id, TestCaseRequestDto testCaseRequestDto);
	
}
