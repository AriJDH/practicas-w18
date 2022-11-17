package com.meli.springmanejoexcepcionesp1vivo.controller;

import com.meli.springmanejoexcepcionesp1vivo.dto.request.BlogDto;
import com.meli.springmanejoexcepcionesp1vivo.dto.response.BlogCreateDto;
import com.meli.springmanejoexcepcionesp1vivo.dto.response.BlogGetDto;
import com.meli.springmanejoexcepcionesp1vivo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogGetDto>> getAllBlog(){
        return new ResponseEntity<>(iBlogService.getAllBlog(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogGetDto> getBlog(@PathVariable Integer id){
        return new ResponseEntity<>(iBlogService.getBlog(id), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<BlogCreateDto> postBlog(@RequestBody BlogDto blogDto){
        return new ResponseEntity<>(iBlogService.createBlog(blogDto), HttpStatus.OK);
    }
}
