package com.ohmy.jpa.service;

import com.ohmy.jpa.entity.Student;

import java.util.List;

public interface IStudentService {
    void saveStudent(Student student);
    List<Student> getStudents();
    Student findStudent(long id);
    void deleteStudent(long id);
}
