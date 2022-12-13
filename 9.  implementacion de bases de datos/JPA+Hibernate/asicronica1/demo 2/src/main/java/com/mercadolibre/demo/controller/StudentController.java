package com.mercadolibre.demo.controller;

import com.mercadolibre.demo.model.Student;
import com.mercadolibre.demo.repository.StudentRepository;
import com.mercadolibre.demo.service.iStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private iStudentService studentService;

    @PostMapping("/create")
    public String createStudent(Student stu) {
        studentService.saveStudent(stu);
        return "Student creado con éxito";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/edit/{id}")
    public Student editStudent(
            @PathVariable Long id,
            @RequestParam("name") String newName,
            @RequestParam("lastname") String newLastname){
        Student stu = studentService.findStudent(id);
        stu.setLastname(newLastname);
        stu.setName(newName);
        studentService.saveStudent(stu);
        return stu;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student eliminado con éxito";
    }



}
