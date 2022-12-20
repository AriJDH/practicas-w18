package com.example.crud.service;

import com.example.crud.model.Student;
import com.example.crud.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student editStudent(Long id, String name, String lastname) {
        Student student = findStudente(id);
        student.setName(name);
        student.setLastname(lastname);
        saveStudent(student);
        return  student;
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudente(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return  student;
    }
}
