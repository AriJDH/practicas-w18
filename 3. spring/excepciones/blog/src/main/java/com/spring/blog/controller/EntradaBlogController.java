package com.spring.blog.controller;

import com.spring.blog.dto.EntradaBlogDtoReq;
import com.spring.blog.dto.EntradaBlogDtoRes;
import com.spring.blog.dto.IdDto;
import com.spring.blog.exception.NotFoundException;
import com.spring.blog.service.BlogService;
import com.spring.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class EntradaBlogController {
    IBlogService blogService;

    public EntradaBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<IdDto> addEntry(@RequestBody EntradaBlogDtoReq entradaBlogDtoReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.addEntry(entradaBlogDtoReq));
    }

    @GetMapping
    public ResponseEntity<List<EntradaBlogDtoRes>> getAllEntries() {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDtoRes> getEntryById(@PathVariable Integer id) {
        EntradaBlogDtoRes entradaBlogDtoRes = blogService.getEntryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(entradaBlogDtoRes);
    }
}
