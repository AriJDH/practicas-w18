package com.example.blog.controller;

import com.example.blog.dto.request.EntradaBlogRequestDTO;
import com.example.blog.dto.response.EntradaBlogResponseDTO;
import com.example.blog.dto.response.EntradaBlogResponseIdDTO;
import com.example.blog.service.IServiceEntradaBlog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {

    private IServiceEntradaBlog serviceEntradaBlog;

    public EntradaBlogController(IServiceEntradaBlog serviceEntradaBlog) {
        this.serviceEntradaBlog = serviceEntradaBlog;
    }

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogResponseIdDTO> add(@RequestBody EntradaBlogRequestDTO request){
        return new ResponseEntity<>(serviceEntradaBlog.add(request), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(serviceEntradaBlog.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogResponseDTO>> listAll(){
        return new ResponseEntity<>(serviceEntradaBlog.listAll(), HttpStatus.OK);
    }

}
