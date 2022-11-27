package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/registerStudent")
    public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.create(stu);
        return ResponseEntity.ok(stu); // Cambiado el null del body por el StudentDTO
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return this.studentService.read(id);
    }

    @PostMapping("/modifyStudent")
    public ResponseEntity<?> modifyStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.update(stu);
        return ResponseEntity.ok("Estudiante modificado"); // Devuelve un mensaje para no devolver null
    }

    @DeleteMapping("/removeStudent/{id}") // Cambiado el Get por el Delete que es el método correcto
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.ok("Estudiante eliminado"); // Cambiado el null del body mensaje OK
    }

    @GetMapping("/listStudents")
    public Set<StudentDTO> listStudents() {
        return this.studentService.getAll();
    }

}
