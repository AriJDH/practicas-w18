package com.mercadolibre.demo.service;

import com.mercadolibre.demo.model.Student;

import java.util.List;

public interface iStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student stu);
    public void deleteStudent(Long id);
    public Student findStudent(Long id);

}
