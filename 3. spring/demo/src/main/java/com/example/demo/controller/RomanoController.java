package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RomanoController {

    @GetMapping("/{number}")
    public String toRoman(@PathVariable Integer number) {

        Map<Integer, String> romanos = new HashMap<>();

        romanos.put(1, "I");
        romanos.put(2, "II");
        romanos.put(3, "III");
        romanos.put(4, "IV");
        romanos.put(5, "V");
        romanos.put(7, "VII");
        romanos.put(10, "X");
        romanos.put(13, "XIII");
        romanos.put(50, "L");
        romanos.put(100, "C");
        romanos.put(500, "D");
        romanos.put(1000, "M");

        if(romanos.get(number) != null){
            return "El número romano correspondiente a " + number + " es " +  romanos.get(number);
        }else{
            return "No se encontró el número ingresado";
        }



    }
}
