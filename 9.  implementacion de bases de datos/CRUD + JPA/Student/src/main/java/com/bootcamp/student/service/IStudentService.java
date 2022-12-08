package com.bootcamp.student.service;
import java.util.List;
import com.bootcamp.student.model.Student;

public interface IStudentService {
    public List<Student> getStudent();
    public void saveStudent (Student student);
    public void deleteStudent (long id);
    public Student findStudent (long id);
}
