package com.example.obrasliterarias.controller;


import com.example.obrasliterarias.entity.Literature;
import com.example.obrasliterarias.repository.LiteratureRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    LiteratureRepository literatureRepository;

    public LiteratureController(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks() {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBooks(@RequestBody List<Literature> books) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAllBooks() {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */

    @GetMapping("/query1")
    public ResponseEntity<?> getQuery(@RequestParam String author) {
        return new ResponseEntity<>(literatureRepository.getLiteratureByAuthor(author), OK);
    }

    @GetMapping("/query2")
    public ResponseEntity<?> getQuery2(@RequestParam String title) {
        return new ResponseEntity<>(literatureRepository.getLiteratureByTitleContainsIgnoreCase(title), OK);
    }

    @GetMapping("/query3")
    public ResponseEntity<?> getQuery3(@RequestParam Integer cantPages) {
        return new ResponseEntity<>(literatureRepository.getLiteratureByCantPagesIsGreaterThan(cantPages), OK);
    }

    @GetMapping("/query4")
    public ResponseEntity<?> getQuery4(@RequestParam LocalDate date) {
        return new ResponseEntity<>(literatureRepository.getLiteratureByFirstPostBefore(date), OK);
    }

    @GetMapping("/query5")
    public ResponseEntity<?> getQuery5(@RequestParam LocalDate date) {
        return new ResponseEntity<>(literatureRepository.getLiteratureByFirstPostAfter(date), OK);
    }

    @GetMapping("/query6")
    public ResponseEntity<?> getQuery6(@RequestParam String editorial) {
        return new ResponseEntity<>(literatureRepository.getLiteratureByEditorialIs(editorial), OK);
    }

}