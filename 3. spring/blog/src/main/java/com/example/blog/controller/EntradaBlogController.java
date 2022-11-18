package com.example.blog.controller;

import com.example.blog.dto.request.EntradaBlogDTORes;
import com.example.blog.dto.response.EntradaBlogDTOReq;
import com.example.blog.service.IEntradaBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {
    private final IEntradaBlogService entradaBlogService;

    public EntradaBlogController(IEntradaBlogService entradaBlogService) {
        this.entradaBlogService = entradaBlogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTORes>> findAll(){
        return new ResponseEntity<>(entradaBlogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTORes> findById(@PathVariable Integer id){
        return new ResponseEntity<>(entradaBlogService.findyById(id), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<String> createBlog(@RequestBody EntradaBlogDTOReq entradaBlogDTOReq){
        entradaBlogService.createBlog(entradaBlogDTOReq);
        return new ResponseEntity<>("Blog creado", HttpStatus.OK);
    }

}
