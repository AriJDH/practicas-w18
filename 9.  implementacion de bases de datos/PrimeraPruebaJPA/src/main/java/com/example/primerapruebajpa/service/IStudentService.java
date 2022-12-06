package com.example.primerapruebajpa.service;

import com.example.primerapruebajpa.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student s);
    public void deleteStudent(long id);
    public Student findStudent(long id);
}
