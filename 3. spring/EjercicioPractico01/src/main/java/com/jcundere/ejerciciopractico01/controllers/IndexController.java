package com.jcundere.ejerciciopractico01.controllers;

import com.jcundere.ejerciciopractico01.models.ConverterRoman;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("number/{number}")
    public String conversorMorseToLatin(@PathVariable Integer number) {
        return ConverterRoman.conversorArabigToRoman(number);
    }

}
