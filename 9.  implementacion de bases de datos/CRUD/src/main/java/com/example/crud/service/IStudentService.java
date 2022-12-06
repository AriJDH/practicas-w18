package com.example.crud.service;

import com.example.crud.dto.StudentDTONewRequest;
import com.example.crud.dto.StudentDTOUpdateRequest;
import com.example.crud.model.Student;
import java.util.List;

public interface IStudentService {
    List<Student> getStudents();

    void saveStudent(StudentDTONewRequest stu);

    boolean updateStudent(StudentDTOUpdateRequest stu);

    void deleteStudent(long id);

    Student findStudent(long id);
}
