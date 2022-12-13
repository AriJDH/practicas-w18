package com.bootcamp.elastic.controller;

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

    @GetMapping("")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
    }

    @GetMapping("/byAuthor")
    public ResponseEntity<?> getBooksByAuthor (@RequestParam String author) {
        return new ResponseEntity<>(literatureRepository.findByAuthor(author), OK);
    }

    @GetMapping("/byTitle")
    public ResponseEntity<?> getBooksByTitle (@RequestParam String strsToMatch) {
        return new ResponseEntity<>(literatureRepository.findByTitle(strsToMatch), OK);
    }

    @GetMapping("/byEditorial")
    public ResponseEntity<?> getBooksByEditorial (@RequestParam String editorial) {
        return new ResponseEntity<>(literatureRepository.findByEditorial(editorial), OK);
    }

    @GetMapping("/byPages")
    public ResponseEntity<?> getBooksByPages (@RequestParam int pages) {
        return new ResponseEntity<>(literatureRepository.findByPagesIsGreaterThan(pages), OK);
    }

    @GetMapping("/dateBefore")
    public ResponseEntity<?> getBooksByDateBefore (@RequestParam String date) {
        LocalDate dateBefore = LocalDate.parse(date);
        return new ResponseEntity<>(literatureRepository.findByFirstPostBefore(dateBefore), OK);
    }

    @GetMapping("/dateAfter")
    public ResponseEntity<?> getBooksByDateAfter(@RequestParam String date) {
        LocalDate dateAfter = LocalDate.parse(date);
        return new ResponseEntity<>(literatureRepository.findByFirstPostIsAfter(dateAfter), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */
}
