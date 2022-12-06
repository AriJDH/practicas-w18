package com.example.demoo.service;

import com.example.demoo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
