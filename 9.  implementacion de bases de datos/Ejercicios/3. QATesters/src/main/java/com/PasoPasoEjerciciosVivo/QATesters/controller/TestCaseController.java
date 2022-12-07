package com.PasoPasoEjerciciosVivo.QATesters.controller;

import com.PasoPasoEjerciciosVivo.QATesters.dto.TestCaseDto;
import com.PasoPasoEjerciciosVivo.QATesters.service.TestCaseServiceImp;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	// Buscar todos  -------------------------------- //
	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam(value = "last_update", required = false)
	                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		List<TestCaseDto> testCaseDtoList = new ArrayList<>();
		if(date != null){
			testCaseDtoList = testCaseServiceImp.findAllByDates(date);
		} else testCaseDtoList = testCaseServiceImp.findAll();
		return ResponseEntity.ok().body(testCaseDtoList);
	}
	
	// Buscar por id  -------------------------------- //
	@GetMapping("/{id}")
	public ResponseEntity<TestCaseDto> getById(@PathVariable Long id) {
		return ResponseEntity.ok().body(testCaseServiceImp.findById(id));
	}
	
	// Modificar  -------------------------------- //
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
		testCaseServiceImp.update(id, testCaseDto);
		return ResponseEntity.ok().body("El elemento fue modificado con éxito");
	}
	
	// Eliminar  -------------------------------- //
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		testCaseServiceImp.delete(id);
		return ResponseEntity.ok().body("El elemento fue eliminado con éxito");
	}
	
}
