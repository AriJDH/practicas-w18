package com.PasoPasoEjerciciosVivo.QATesters.service;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITestCaseService {
	
	// Guardar  -------------------------------- //
	void saveAndFlush(TestCaseDto testCaseRequestDto);
	
	// Buscar todos  -------------------------------- //
	List<TestCaseDto> findAll();
	
	// Buscar por id  -------------------------------- //
	TestCaseDto findById(Long id);
	
	// Modificar  -------------------------------- //
	void update(Long id, TestCaseDto testCaseRequestDto);
	
	// Eliminar  -------------------------------- //
	void delete(Long id);
	
	
}
