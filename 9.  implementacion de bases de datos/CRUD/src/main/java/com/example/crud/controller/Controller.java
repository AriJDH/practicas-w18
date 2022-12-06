package com.example.crud.controller;

import com.example.crud.dto.StudentDTONewRequest;
import com.example.crud.dto.StudentDTOUpdateRequest;
import com.example.crud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private IStudentService service;

    public Controller() {
    }

    @PostMapping({"/create"})
    public ResponseEntity<?> createStudent(@RequestBody StudentDTONewRequest student) {
        this.service.saveStudent(student);
        return new ResponseEntity("Estudiante creado correctamente", HttpStatus.CREATED);
    }

    @GetMapping({"/students"})
    public ResponseEntity<?> getStudents() {
        return new ResponseEntity(this.service.getStudents(), HttpStatus.OK);
    }

    @PostMapping({"/update"})
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTOUpdateRequest student) {
        return this.service.updateStudent(student) ? new ResponseEntity("Estudiante actualizado correctamente", HttpStatus.OK) : new ResponseEntity("Estudiante a actualizar no existe", HttpStatus.BAD_REQUEST);
    }

    @PostMapping({"delete/{id}"})
    public ResponseEntity<?> deleteStudent(@PathVariable long id) {
        this.service.deleteStudent(id);
        return new ResponseEntity("El estudiante fue borrado correctamente", HttpStatus.OK);
    }
}
