package com.example.demo.controller;

import com.example.demo.dtos.EntradaBlogDTO;
import com.example.demo.service.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController implements EntradaBlogControllerI {
    @Autowired
    private EntradaBlogService service;


    public EntradaBlogDTO nuevoBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){
        return service.crearNuevoBLog(entradaBlogDTO);
    }

    public EntradaBlogDTO getBlog(@PathVariable Long id){
        return service.getBlog(id);
    }

    public List<EntradaBlogDTO> getBlogs(){
        return service.getBlogs();
    }
}
