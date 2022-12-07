package com.PasoPasoEjerciciosVivo.QATesters.controller;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseDto;
import com.PasoPasoEjerciciosVivo.QATesters.service.TestCaseServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
	
	// Dependencias -------------------------------- //
	TestCaseServiceImp testCaseServiceImp;
	
	public TestCaseController(TestCaseServiceImp testCaseServiceImp) {
		this.testCaseServiceImp = testCaseServiceImp;
	}
	
	// Guardar  -------------------------------- //
	@PostMapping("/new")
	public ResponseEntity<?> save(@RequestBody TestCaseDto testCaseDto) {
		testCaseServiceImp.saveAndFlush(testCaseDto);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
}
