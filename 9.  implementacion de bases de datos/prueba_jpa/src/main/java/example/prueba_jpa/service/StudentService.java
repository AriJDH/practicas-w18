package example.prueba_jpa.service;

import example.prueba_jpa.model.Student;
import example.prueba_jpa.repository.StudentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final StudentRepository stuRepo;


    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList;
    }

    @Override
    public void saveStudent(Student stu) {
        stuRepo.save(stu);

    }

    @Override
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id) {

        Student stu = stuRepo.findById(id).orElse(null);
        return stu;
    }
}
