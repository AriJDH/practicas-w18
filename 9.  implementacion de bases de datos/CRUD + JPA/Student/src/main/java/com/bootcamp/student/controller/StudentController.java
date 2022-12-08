package com.bootcamp.student.controller;

import java.util.List;
import com.bootcamp.student.model.Student;
import com.bootcamp.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    IStudentService studentService;

    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudent(), HttpStatus.OK);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity deleteStudent (@PathVariable long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/findById/{id}")
    public ResponseEntity<Student> findById(@PathVariable long id){
        return new ResponseEntity<>(studentService.findStudent(id), HttpStatus.FOUND);
    }
}