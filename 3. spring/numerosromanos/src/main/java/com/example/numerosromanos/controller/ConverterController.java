package com.example.numerosromanos.controller;

import com.example.numerosromanos.model.ConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {
    private ConverterService model;

    public ConverterController(){
        this.model = new ConverterService();
    }

    @GetMapping("converter/{number}")
    public String getRomanNumber(@PathVariable Integer number){
        return model.romanize(number);
    }

}
