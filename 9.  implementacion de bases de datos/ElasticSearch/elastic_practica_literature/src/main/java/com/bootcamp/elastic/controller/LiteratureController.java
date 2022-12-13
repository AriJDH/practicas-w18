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
        return new ResponseEntity<>(OK);
    }

    /* querys */

    /* Retornar las obras de un autor dado por el usuario. */
    @GetMapping("/titleByAuthor")
    public ResponseEntity<?> getBooksByAuthor (@RequestParam String author) {
        return new ResponseEntity<>(literatureRepository.findAllByAuthor(author), OK);
    }


    /* Retornar las obras que contengan palabras dadas por el usuario en sus títulos. */
    @GetMapping("/booksByTitle")
    public ResponseEntity<?> getBooksByTitle (@RequestBody List<String> wordList) {
        return new ResponseEntity<>(literatureRepository.findAllByTitleIn(wordList), OK);
    }
    /* Retornar las obras con más cantidad de páginas que las indicadas por el usuario. */

    @GetMapping("/booksByCantPages")
    public ResponseEntity<?> getBooksByCantPagesGreaterThan (@RequestParam Integer cantPages) {
        return new ResponseEntity<>(literatureRepository.findAllByCantPagesGreaterThan(cantPages), OK);
    }
    /* Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints). */
    @GetMapping("/booksByFirstPostBefore")
    public ResponseEntity<?> getBooksByFirstPostBefore (@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostBefore(dateDTO.getDate()), OK);
    }

    @GetMapping("/booksByFirstPostAfter")
    public ResponseEntity<?> getBooksByFirstPostAfter (@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(literatureRepository.findAllByFirstPostAfter(dateDTO.getDate()), OK);
    }
    /* Retornar las obras de una misma editorial. */
    @GetMapping("/booksByEditorial")
    public ResponseEntity<?> getBooksByEditorial (@RequestParam String editorial) {
        return new ResponseEntity<>(literatureRepository.findAllByEditorial(editorial), OK);
    }

}

