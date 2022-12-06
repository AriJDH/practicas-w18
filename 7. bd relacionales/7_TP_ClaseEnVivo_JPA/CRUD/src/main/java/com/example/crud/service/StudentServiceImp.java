package com.example.crud.service;

import com.example.crud.dto.StudentDTONewRequest;
import com.example.crud.dto.StudentDTOUpdateRequest;
import com.example.crud.model.Student;
import com.example.crud.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements IStudentService{
    private final IStudentRepository stuRepo;

    public StudentServiceImp (IStudentRepository stuRepo){
        this.stuRepo = stuRepo;
    }

    @Override
    public List<Student> getStudents() {
        return stuRepo.findAll();
    }

    @Override
    public void saveStudent(StudentDTONewRequest stu) {
        Student student = new Student();
        student.setDni(stu.getDni());
        student.setName(stu.getName());
        student.setLastname(stu.getLastname());
        stuRepo.save(student);
    }

    @Override
    public boolean updateStudent(StudentDTOUpdateRequest stu) {
        Student student = stuRepo.findById(stu.getId()).orElse(null);
        if( student == null ){
            return false;
        }
        student.setId(stu.getId());
        student.setName(stu.getName());
        student.setLastname(stu.getLastname());
        stuRepo.save(student);
        return true;
    }

    @Override
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);
    }

    @Override
    public Student findStudent(long id) {
        return stuRepo.findById(id).orElse(null);
    }

}
