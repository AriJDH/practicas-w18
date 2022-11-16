package com.example.blogyoutube.controller;

import com.example.blogyoutube.dto.request.EntradaBlogDtoReq;
import com.example.blogyoutube.dto.response.EntradaBlogMessage;
import com.example.blogyoutube.dto.response.EntradaBlogRes;
import com.example.blogyoutube.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    @Autowired
    private IEntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogMessage> crearBlog(@RequestBody EntradaBlogDtoReq blog){
        return new ResponseEntity<>(entradaBlogService.save(blog), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogRes> buscarBlogPorId(@PathVariable Integer id){
        return new ResponseEntity<>(entradaBlogService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<Map<Integer, EntradaBlogRes>> listarBlogs(){
        return new ResponseEntity(entradaBlogService.findAll(), HttpStatus.OK);
    }
}
