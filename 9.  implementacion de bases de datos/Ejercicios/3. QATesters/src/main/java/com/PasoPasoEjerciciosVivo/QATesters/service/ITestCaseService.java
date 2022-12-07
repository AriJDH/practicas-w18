package com.PasoPasoEjerciciosVivo.QATesters.service;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITestCaseService {
	
	// Guardar
	void saveAndFlush(TestCaseDto testCaseRequestDto);
	
	// Buscar Todos
	List<TestCaseDto> findAll();
	
	// Buscar por Id
	TestCaseDto findById(Long id);
	
	// Eliminar por id
	void delete(Long id);
	
	// Modificar
	void update(Long id, TestCaseDto testCaseRequestDto);
	
}
