package com.example.primerapruebajpa.controller;

import com.example.primerapruebajpa.model.Student;
import com.example.primerapruebajpa.repository.IStudentRepository;
import com.example.primerapruebajpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private IStudentService service;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student s){
        this.service.saveStudent(s);
        return "Estudiante creado.";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.service.getStudents();
    }

    @PostMapping("/edit/{id}")
    public Student editStudent(@PathVariable long id, @RequestParam ("name") String newName,
                                @RequestParam ("lastName") String newLastName){
        Student s = this.service.findStudent(id);
        s.setName(newName);
        s.setLastName(newLastName);
        this.service.saveStudent(s);
        return s;
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        this.service.deleteStudent(id);
        return "Estudiante eliminado.";
    }
}
