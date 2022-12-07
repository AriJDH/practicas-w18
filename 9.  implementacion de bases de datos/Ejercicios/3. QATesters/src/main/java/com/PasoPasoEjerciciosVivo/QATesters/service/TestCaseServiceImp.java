package com.PasoPasoEjerciciosVivo.QATesters.service;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseDto;
import com.PasoPasoEjerciciosVivo.QATesters.model.TestCase;
import com.PasoPasoEjerciciosVivo.QATesters.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImp implements ITestCaseService {
	
	// Dependencias  -------------------------------- //
	ITestCaseRepository testCaseRepository;
	ObjectMapper mapper;
	
	public TestCaseServiceImp(ITestCaseRepository testCaseRepository,
	                          ObjectMapper mapper) {
		this.testCaseRepository = testCaseRepository;
		this.mapper = mapper;
	}
	
	// Guardar  -------------------------------- //
	@Override
	public void saveAndFlush(TestCaseDto testCaseDto) {
		TestCase testCase = mapper.convertValue(testCaseDto, TestCase.class);
		testCaseRepository.saveAndFlush(testCase);
	}
	
	// Buscar todos  -------------------------------- //
	@Override
	public List<TestCaseDto> findAll() {
		List<TestCase> testCaseList= testCaseRepository
						.findAll();
		List<TestCaseDto> testCaseDtoList = testCaseList
						.stream()
						.map(testCase -> mapper.convertValue(testCase, TestCaseDto.class))
						.collect(Collectors.toList());
		if (testCaseDtoList.size() == 0) {
			throw new EmptyStackException(); // TODO pendiente investigar si corresponde esta excepción
		}
		return testCaseDtoList;
	}
	
	// Buscar por id  -------------------------------- //
	@Override
	public TestCaseDto findById(Long id) {
		return mapper
						.convertValue(testCaseRepository
										              .findById(id)
										              .orElseThrow(() ->
														                           new NoSuchElementException("El id no fue encontrado")),
						              TestCaseDto.class);
	}
	
	// Modificar  -------------------------------- //
	@Override
	public void update(Long id, TestCaseDto testCaseDto) {
		TestCase testCaseResult = testCaseRepository.findById(id).orElseThrow(
						()-> new NoSuchElementException("El id no fue encontrado"));
		TestCase testCaseNew = mapper.convertValue(testCaseDto, TestCase.class);
		testCaseNew.setIdCase(id);
		testCaseRepository.saveAndFlush(testCaseNew);
	}
	
	// Eliminar  -------------------------------- //
	@Override
	public void delete(Long id) {
		TestCase testCase = testCaseRepository.findById(id).orElseThrow(
						()-> new NoSuchElementException("El id no fue encontrado"));
		testCaseRepository.deleteById(id);
	}
	
	// Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.
	
}
