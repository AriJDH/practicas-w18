package com.dh.demo.api.controller;

import com.dh.demo.api.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/morse")
public class MorseCodeController {

    private final MorseService service;

    @Autowired
    public MorseCodeController(MorseService service) {
        this.service = service;
    }

    @GetMapping("/{code}")
    public ResponseEntity<String> getMorseCode(@PathVariable String code) {
        return ResponseEntity.ok().body(service.getMorseCode(code));
    }

}
