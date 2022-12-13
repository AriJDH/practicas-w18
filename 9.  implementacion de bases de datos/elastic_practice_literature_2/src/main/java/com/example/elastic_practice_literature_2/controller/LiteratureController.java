package com.example.elastic_practice_literature_2.controller;

import com.example.elastic_practice_literature_2.dto.DateDTO;
import com.example.elastic_practice_literature_2.entity.Literature;
import com.example.elastic_practice_literature_2.repository.LiteratureRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    LiteratureRepository literatureRepository;

    public LiteratureController(LiteratureRepository literatureRepository ) {
        this.literatureRepository = literatureRepository;
    }

    @GetMapping("/getBooks")
    public ResponseEntity<?> getBooks () {
        return new ResponseEntity<>(literatureRepository.findAll(), OK);
    }

    @PostMapping("/saveBooks")
    public ResponseEntity<?> saveBooks(@RequestBody List<Literature> books ) {
        return new ResponseEntity<>(literatureRepository.saveAll(books), CREATED);
    }

    @DeleteMapping("/deleteAllBooks")
    public ResponseEntity<?> deleteAllBooks() {
        literatureRepository.deleteAll();
        return new ResponseEntity<>("https://www.youtube.com/watch?v=i_cVJgIz_Cs", OK);
    }

    /* querys */
    @GetMapping("/findByAutor")
    public ResponseEntity<?> findByAutor(@RequestParam String autor) {
        return new ResponseEntity<>(literatureRepository.findByAutor(autor), OK);
    }

    @GetMapping("/findByNombreObraIn")
    public ResponseEntity<?> findByNombreObraIn(@RequestBody List<String> words) {
        return new ResponseEntity<>(literatureRepository.findByNombreObraIn(words), OK);
    }

    @GetMapping("/findByCantidadPaginasGreaterThan")
    public ResponseEntity<?> findByCantidadPaginasGreaterThan(@RequestParam Integer cantidadPaginas) {
        return new ResponseEntity<>(literatureRepository.findByCantidadPaginasGreaterThan(cantidadPaginas), OK);

    }

    @GetMapping("/findByFirstPostBefore")
    public ResponseEntity<?> findByFirstPostBefore(@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(literatureRepository.findByFirstPostBefore(dateDTO.getDate()), OK);
    }

    @GetMapping("/findByFirstPostAfter")
    public ResponseEntity<?> findByFirstPostAfter(@RequestBody DateDTO dateDTO) {
        return new ResponseEntity<>(literatureRepository.findByFirstPostAfter(dateDTO.getDate()), OK);
    }

    @GetMapping("/findByEditorial")
    public ResponseEntity<?> findByEditorial(@RequestParam String editorial){
        return new ResponseEntity<>(literatureRepository.findByEditorial(editorial), OK);
    }
}
