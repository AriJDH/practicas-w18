package com.example.Blog.controller;

import com.example.Blog.dto.EntradaBlogDtoRequest;
import com.example.Blog.dto.EntradaBlogDtoResponse;
import com.example.Blog.dto.EntradaBlogIdDtoResponse;
import com.example.Blog.repository.IEntradaBlogRepository;
import com.example.Blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {
    @Autowired
    private IEntradaBlogService entradaBlogService;

    @PostMapping("/")
    public ResponseEntity<EntradaBlogDtoResponse> agregarEntrada(@RequestBody EntradaBlogDtoRequest entradaBlog) {
        return new ResponseEntity<>(entradaBlogService.agregarBlog(entradaBlog), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogIdDtoResponse> buscarPorId(@PathVariable Long id) {
        return  new ResponseEntity<>(entradaBlogService.buscarBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogIdDtoResponse>> buscarTodos(){
        return new ResponseEntity<>(entradaBlogService.buscarTodos(), HttpStatus.OK);   
    }
}
