package com.example.crud.controller;

import com.example.crud.dto.StudentDTONewRequest;
import com.example.crud.dto.StudentDTOUpdateRequest;
import com.example.crud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private IStudentService service;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTONewRequest student){
        service.saveStudent(student);
        return new ResponseEntity<>("Estudiante creado correctamente",HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(service.getStudents(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTOUpdateRequest student){
        if (service.updateStudent(student)){
            return new ResponseEntity<>("Estudiante actualizado correctamente",HttpStatus.OK);
        }
        return new ResponseEntity<>("Estudiante a actualizar no existe",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        service.deleteStudent(id);
        return new ResponseEntity<>("El estudiante fue borrado correctamente", HttpStatus.OK);
    }

}
