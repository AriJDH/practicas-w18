package com.demo.demojpa.service;

import com.demo.demojpa.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final IStudentRepository studentRepository;
}
