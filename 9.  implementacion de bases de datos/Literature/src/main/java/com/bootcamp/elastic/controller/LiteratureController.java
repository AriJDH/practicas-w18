package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
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

    public LiteratureController ( LiteratureRepository literatureRepository ) {
        this.literatureRepository = literatureRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveBooks ( @RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */

    @GetMapping("/author")
    public ResponseEntity<?> getObrasByauthor ( @RequestParam String author) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByAuthor(author), OK);
    }

    @GetMapping("/titles")
    public ResponseEntity<?> getObrasByTitle ( @RequestParam String title) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByTitleIs(title), OK);
    }

    @GetMapping("/page")
    public ResponseEntity<?> getObrasByPage ( @RequestParam int pages) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByCantPagesGreaterThan(pages), OK);
    }

    @GetMapping("/editorial")
    public ResponseEntity<?> getObrasByEditorial ( @RequestParam String editorial) {
        return new ResponseEntity<>(literatureRepository.findLiteratureByEditorialContaining(editorial), OK);
    }

    @GetMapping("/dateBefore")
    public ResponseEntity<?> getObrasByPostBefore ( @RequestBody DateDTO date) {
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostBefore(date.getDate()), OK);
    }

    @GetMapping("/dateAfter")
    public ResponseEntity<?> getObrasByPostAfter ( @RequestBody DateDTO date ) {
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostAfter(date.getDate()), OK);
    }
}
