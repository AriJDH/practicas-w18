package com.bootcamp.romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class RomanRestController {
    @GetMapping("decimalToRoman/{decimal}")
    public String decimalToRoman(@PathVariable int decimal) {
        StringBuilder romanNumeral = new StringBuilder();
        HashMap<String, Integer> decimalMap = new LinkedHashMap<>();

        decimalMap.put("M", Math.floorMod(decimal, 5000)/1000);
        decimalMap.put("D", Math.floorMod(decimal, 1000) >= 500 ? 1 : 0);
        decimalMap.put("C", Math.floorMod(decimal, 500)/100);
        decimalMap.put("L", Math.floorMod(decimal, 100) >= 50 ? 1 : 0);
        decimalMap.put("X", Math.floorMod(decimal, 50)/10);
        decimalMap.put("V", Math.floorMod(decimal, 10) >= 5 ? 1 : 0);
        decimalMap.put("I", Math.floorMod(decimal, 5));

        for (Map.Entry<String, Integer> stringIntegerEntry : decimalMap.entrySet()) {
            romanNumeral.append(String.valueOf(stringIntegerEntry.getKey()).repeat(Math.max(0, stringIntegerEntry.getValue())));
        }

        return "Roman numeral = " + romanNumeral;
    }
}
