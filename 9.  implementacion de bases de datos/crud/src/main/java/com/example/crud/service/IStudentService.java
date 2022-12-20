package com.example.crud.service;

import com.example.crud.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> getStudents();
    public void saveStudent (Student student);
    public void deleteStudent (Long id);
    public Student findStudente(Long id);

    public Student editStudent(Long id, String name, String lastname);
}
