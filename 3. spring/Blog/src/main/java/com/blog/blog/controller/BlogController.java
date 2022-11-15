package com.blog.blog.controller;

import com.blog.blog.dto.request.EntradaBlogDTOreq;
import com.blog.blog.dto.response.CreacionDTOres;
import com.blog.blog.dto.response.EntradaBlogDTOres;
import com.blog.blog.exception.DuplicatedException;
import com.blog.blog.exception.NotFoundException;
import com.blog.blog.service.BlogServiceImp;
import com.blog.blog.service.IblogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private final IblogService blogService;

    public BlogController(BlogServiceImp service){
        this.blogService = service;
    }


    @PostMapping("/blog")
    public ResponseEntity<CreacionDTOres> crearEntrada(@RequestBody EntradaBlogDTOreq entrada){
        CreacionDTOres res = blogService.addEntradaBlog(entrada);
        if(res == null){
            throw new DuplicatedException("No pudo ser creada la entrada por id duplicado");
        }
        return new ResponseEntity(res,HttpStatus.CREATED);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<CreacionDTOres>> findAll(){
        return new ResponseEntity(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTOres> getById(@PathVariable long id){
        EntradaBlogDTOres blog= blogService.findById(id);
        if(blog == null){
            throw new NotFoundException("El libro con id " + id + " no fue encontrado");
        }
        return ResponseEntity.ok(blogService.findById(id));
    }
}
