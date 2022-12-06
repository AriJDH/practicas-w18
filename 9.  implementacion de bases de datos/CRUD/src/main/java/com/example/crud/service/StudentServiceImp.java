package com.example.crud.service;

import com.example.crud.dto.StudentDTONewRequest;
import com.example.crud.dto.StudentDTOUpdateRequest;
import com.example.crud.model.Student;
import com.example.crud.repository.IStudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements IStudentService {
    private final IStudentRepository stuRepo;

    public StudentServiceImp(IStudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    public List<Student> getStudents() {
        return this.stuRepo.findAll();
    }

    public void saveStudent(StudentDTONewRequest stu) {
        Student student = new Student();
        student.setDni(stu.getDni());
        student.setName(stu.getName());
        student.setLastname(stu.getLastname());
        this.stuRepo.save(student);
    }

    public boolean updateStudent(StudentDTOUpdateRequest stu) {
        Student student = this.stuRepo.findById(stu.getId()).orElse(null);
        if (student == null) {
            return false;
        } else {
            student.setId(stu.getId());
            student.setName(stu.getName());
            student.setLastname(stu.getLastname());
            this.stuRepo.save(student);
            return true;
        }
    }

    public void deleteStudent(long id) {
        this.stuRepo.deleteById(id);
    }

    public Student findStudent(long id) {
        return this.stuRepo.findById(id).orElse(null);
    }
}

