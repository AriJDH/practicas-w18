package com.example.prueba.service;

import com.example.prueba.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
