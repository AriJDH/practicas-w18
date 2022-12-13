package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
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

    @GetMapping("")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
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

    @GetMapping("/one")
    public ResponseEntity<?> getBooksByAuthor (@RequestParam String author) {
        return new ResponseEntity<>(literatureRepository.findAllByAuthor(author), OK);
    }

    @GetMapping("/two")
    public ResponseEntity<?> getBooksByTitle (@RequestBody List<String> wordList) {
        return new ResponseEntity<>(literatureRepository.findAllByTitleIn(wordList), OK);
    }

    @GetMapping("/three")
    public ResponseEntity<?> getBooksByCantPagesGreaterThan (@RequestParam Integer cantPages) {
        return new ResponseEntity<>(literatureRepository.findAllByCantPagesGreaterThan(cantPages), OK);
    }

    @GetMapping("/four")
    public ResponseEntity<?> getBooksByFirstPostBefore (@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostBefore(dateDTO.getDate()), OK);
    }

    @GetMapping("/four2")
    public ResponseEntity<?> getBooksByFirstPostAfter (@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostAfter(dateDTO.getDate()), OK);
    }

    @GetMapping("/five")
    public ResponseEntity<?> getBooksByEditorialMatches (@RequestParam String editorial) {
        return new ResponseEntity<>(literatureRepository.findAllByEditorialMatchesRegex(editorial), OK);
    }

}
