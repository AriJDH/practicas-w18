package com.example.codigomorse.controller;

import com.example.codigomorse.model.ConverterModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    private ConverterModel model;

    public ConverterController(){
        this.model = new ConverterModel();
    }

    @GetMapping("/converter/{morse}")
    public String converter(@PathVariable String morse){
        return model.decode(morse);
    }
}
