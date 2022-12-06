package com.implementandoJPA.implementandoJPA.service;

import com.implementandoJPA.implementandoJPA.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;}
}
