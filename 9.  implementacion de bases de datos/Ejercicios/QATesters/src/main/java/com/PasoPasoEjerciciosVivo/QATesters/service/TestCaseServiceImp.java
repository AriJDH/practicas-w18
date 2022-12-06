package com.PasoPasoEjerciciosVivo.QATesters.service;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseRequestDto;
import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseResponseDto;
import com.PasoPasoEjerciciosVivo.QATesters.model.TestCase;
import com.PasoPasoEjerciciosVivo.QATesters.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseServiceImp implements ITestCaseService {
	
	final
	ITestCaseRepository testCaseRepository;
	final
	ObjectMapper mapper;
	
	public TestCaseServiceImp(ITestCaseRepository testCaseRepository, ObjectMapper mapper) {
		this.testCaseRepository = testCaseRepository;
		this.mapper = mapper
						.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						           false);
	}
	
	@Override
	public void saveAndFlush(TestCaseRequestDto testCaseRequestDto) {
		TestCase testCase = mapper.convertValue(testCaseRequestDto, TestCase.class);
		testCaseRepository.saveAndFlush(testCase);
	}
	
	@Override
	public List<TestCaseResponseDto> findAll() {
		return null;
	}
	
	@Override
	public TestCaseResponseDto findById(Long id) {
		return null;
	}
	
	@Override
	public void delete(Long id) {
	
	}
	
	@Override
	public void update(Long id, TestCaseRequestDto testCaseRequestDto) {
	
	}
}
