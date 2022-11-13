package com.example.morsecode.controller;

import com.example.morsecode.service.CodeMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeMorseController {
    @Autowired
    private CodeMorseService codeMorseService;
    @GetMapping("/api/frase/{frase}")
    public ResponseEntity<String> printFrase(@PathVariable String frase){
        return new ResponseEntity<>(codeMorseService.printFrase(frase), HttpStatus.OK);
    }
    @GetMapping("/api/morse/{morse}")
    public ResponseEntity<String> printCodeMorse(@PathVariable String morse){
        return new ResponseEntity<>(codeMorseService.printCodeMorse(morse), HttpStatus.OK);
    }
}
