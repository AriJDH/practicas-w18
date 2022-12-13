package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.request.LiteratureDTORequest;
import com.bootcamp.elastic.dto.response.LiteratureDTOResponse;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    @Autowired
    LiteratureService literatureService;


    @GetMapping("")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureService.getAll(), OK);
    }

    @GetMapping("/one")
    public ResponseEntity<?> getBooksByAuthor (@RequestParam(name = "author") String author) {
        return new ResponseEntity<>(literatureService.getAllByAuthor(author), OK);
    }
    @GetMapping("/two")
    public ResponseEntity<?> getBooksByTitleKeyword (@RequestBody List<String> keywords) {
        return new ResponseEntity<>(literatureService.getAllByTitleKeyword(keywords), OK);
    }
    @GetMapping("/three")
    public ResponseEntity<?> getBooksByPagesGreater (@RequestParam(name = "cantPages") int pages) {
        return new ResponseEntity<>(literatureService.getAllByPagesGreater(pages), OK);
    }
    @GetMapping("/four")
    public ResponseEntity<?> getBooksByFirstPostBefore (@RequestBody Map<String, String> body) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(body.get("date"), formatter);
        return new ResponseEntity<>(literatureService.getAllByFirstPostBefore(date), OK);
    }
    @GetMapping("/four2")
    public ResponseEntity<?> getBooksByFirstPostAfter (@RequestBody Map<String, String> body) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(body.get("date"), formatter);
        return new ResponseEntity<>(literatureService.getAllByFirstPostAfter(date), OK);
    }
    @GetMapping("/five")
    public ResponseEntity<?> getBooksByEditorial(@RequestParam(name = "editorial") String editorial) {
        return new ResponseEntity<>(literatureService.getAllByEditorial(editorial), OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveBooks ( @RequestBody List<LiteratureDTORequest> books ) {
        return new ResponseEntity<>(literatureService.saveAll(books), CREATED);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteAllBooks () {
        literatureService.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }


    /* querys */
}
