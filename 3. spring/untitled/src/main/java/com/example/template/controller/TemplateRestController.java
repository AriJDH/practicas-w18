package com.example.template.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateRestController {

    @GetMapping("/template/{par1}")
    public ResponseEntity<?> funcionTemp(@PathVariable String par1){
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }
}
