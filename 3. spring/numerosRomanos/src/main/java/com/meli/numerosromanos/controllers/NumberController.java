package com.meli.numerosromanos.controllers;

import com.meli.numerosromanos.domain.RomanConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    @GetMapping
    public String saludar(){
        return "Buenas!";
    }
    @GetMapping("/romanConverter/{value}")
    public String converToRoman(@PathVariable int value){
        return RomanConverter.intToRoman(value);
    }
}
