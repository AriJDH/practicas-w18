package com.PasoPasoEjerciciosVivo.QATesters.service;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseDto;
import com.PasoPasoEjerciciosVivo.QATesters.model.TestCase;
import com.PasoPasoEjerciciosVivo.QATesters.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseServiceImp implements ITestCaseService {
	
	ITestCaseRepository testCaseRepository;
	
	ObjectMapper mapper;
	
	public TestCaseServiceImp(ITestCaseRepository testCaseRepository,
	                          ObjectMapper mapper) {
		this.testCaseRepository = testCaseRepository;
		this.mapper = mapper;
	}
	
	@Override
	public void saveAndFlush(TestCaseDto testCaseDto) {
		TestCase testCase = mapper.convertValue(testCaseDto, TestCase.class);
		testCaseRepository.saveAndFlush(testCase);
	}
	
	@Override
	public List<TestCaseDto> findAll() {
		return null;
	}
	
	@Override
	public TestCaseDto findById(Long id) {
		return null;
	}
	
	@Override
	public void delete(Long id) {
	
	}
	
	@Override
	public void update(Long id, TestCaseDto testCaseRequestDto) {
	
	}
}
