package com.gem.jewelrystore.controller;

import com.gem.jewelrystore.dto.request.JewelryRequest;
import com.gem.jewelrystore.dto.response.JewelryCreatedResponse;
import com.gem.jewelrystore.entity.Jewelry;
import com.gem.jewelrystore.service.IJewelryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {

    private final IJewelryService jewelryService;

    public JewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/new")
    public ResponseEntity<JewelryCreatedResponse> newJewelry(@RequestBody JewelryRequest jewelryRequest) {
        return new ResponseEntity<>(jewelryService.createJewelry(jewelryRequest), HttpStatus.CREATED);
    }

//    @GetMapping("")
//    public List<Jewelry> getStudents() {
//        return jewelryService.getAllJewelry();
//    }
//
//    @PostMapping("/edit/{id}")
//    public Student editStudent(@PathVariable long id,
//                       @RequestParam("name") String newName,
//                       @RequestParam("lastname") String newLastname) {
//        Student student = jewelryService.findStudent(id);
//        student.setName(newName);
//        student.setLastname(newLastname);
//        return student;
//    }
//
//    @PostMapping("/delete/{id}")
//    public String deleteStudent(@PathVariable long id) {
//        jewelryService.deleteStudent(id);
//        return "El estudiante fue borrado correctamente";
//    }
}
