package com.longblink.hibernate.service;

import com.longblink.hibernate.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
