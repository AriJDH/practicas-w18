package com.bootcamp.student.service;

import java.util.List;

import com.bootcamp.student.model.Student;
import com.bootcamp.student.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudent() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findStudent(long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return null;
    }
}
