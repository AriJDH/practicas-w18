package com.example.primerapruebajpa.service;

import com.example.primerapruebajpa.model.Student;
import com.example.primerapruebajpa.repository.IStudentRepository;
//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final IStudentRepository repo;

    public StudentService(IStudentRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return this.repo.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student s) {
        this.repo.save(s);
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
        this.repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id) {
        return this.repo.findById(id).orElse(null);
    }
}
