package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.request.BlogDtoRequest;
import com.bootcamp.blog.dto.response.BlogDtoResponse;
import com.bootcamp.blog.exceptions.BlogException;
import com.bootcamp.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> addBlog(@RequestBody BlogDtoRequest blogDtoRequest){
        if(blogService.existeId(blogDtoRequest.getId()))
        {
            throw  new BlogException("Ya existe el blog con el Id: " + blogDtoRequest.getId());
        }
        blogService.creaBlog(blogDtoRequest);
        return new ResponseEntity( "Se creo correctamente con el siguiente Id: " + blogDtoRequest.getId(), HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDtoResponse> findById(@PathVariable Integer id){
        if (blogService.findById(id).stream().count() < 1){
            throw  new BlogException("No se encontraron conincidencias");
        }
        return new ResponseEntity(blogService.findById(id), HttpStatus.OK);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDtoResponse>> findAllBlog(){
        return new ResponseEntity<>(blogService.getAllBlog(), HttpStatus.OK);
    }

}
