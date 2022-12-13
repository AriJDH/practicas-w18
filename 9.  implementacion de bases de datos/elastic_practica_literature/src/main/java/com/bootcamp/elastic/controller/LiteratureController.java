package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public ResponseEntity<?> saveBooks ( @RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllBooks () {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */
    @GetMapping("/getByAuthor")
    public ResponseEntity<?> getByAuthor(@RequestParam String author) {
        return ResponseEntity.status(OK).body(literatureRepository.findAllByAuthorIs(author));
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<?> getByTitle(@RequestParam String title) {
        return ResponseEntity.status(OK).body(literatureRepository.findAllByTitleIs(title));
    }

    @GetMapping("/getByCantPages")
    public ResponseEntity<?> getByCantPages(@RequestParam int cantPages) {
        return ResponseEntity.status(OK).body(literatureRepository.findAllByCantPagesGreaterThan(cantPages));
    }
}
