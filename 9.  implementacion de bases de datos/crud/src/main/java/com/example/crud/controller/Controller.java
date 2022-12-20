package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> studentList = studentService.getStudents();
        return studentList;
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable Long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastname") String newLastname){

        return studentService.editStudent(id, newName, newLastname);
    }

    @PostMapping("delete/{id}")
    public String deleteStudente(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }
}
