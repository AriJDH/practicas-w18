package com.PasoPasoEjerciciosVivo.QATesters.controller;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseRequestDto;
import com.PasoPasoEjerciciosVivo.QATesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

	final
	ITestCaseService testCaseService;
	
	public TestCaseController(ITestCaseService testCaseService) {this.testCaseService = testCaseService;}
	
	@PostMapping("/new")
	public ResponseEntity<?> save(@RequestBody TestCaseRequestDto testCaseRequestDto){
		testCaseService.saveAndFlush(testCaseRequestDto);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

}
