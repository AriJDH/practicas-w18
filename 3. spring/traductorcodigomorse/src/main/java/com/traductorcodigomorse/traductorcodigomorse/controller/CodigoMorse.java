package com.traductorcodigomorse.traductorcodigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorse {
    @GetMapping("codigoMorse/{palabra}")
    public String conversorCodigoMorse(@PathVariable String palabra){

        String[] palabraSpliteada = palabra.split(" ");


        return "" ;
    }
}
