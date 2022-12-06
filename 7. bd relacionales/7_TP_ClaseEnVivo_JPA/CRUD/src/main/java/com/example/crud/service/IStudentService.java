package com.example.crud.service;

import com.example.crud.dto.StudentDTONewRequest;
import com.example.crud.dto.StudentDTOUpdateRequest;
import com.example.crud.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent (StudentDTONewRequest stu);
    public boolean updateStudent (StudentDTOUpdateRequest stu);
    public void deleteStudent (long id);
    public Student findStudent (long id);
}
