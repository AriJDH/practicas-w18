package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MorseController {
    @GetMapping("morseToText/{morse}")
    public String morseToText(@PathVariable String morse) {
        HashMap<String, String> diccionarioMorse = new HashMap<>();
        diccionarioMorse.put(".-", "A");
        diccionarioMorse.put("-...", "B");
        diccionarioMorse.put("-.-.", "C");
        diccionarioMorse.put("----", "CH");
        diccionarioMorse.put("-..", "D");
        diccionarioMorse.put(".", "E");
        diccionarioMorse.put("..-.", "F");
        diccionarioMorse.put("--.", "G");
        diccionarioMorse.put("....", "H");
        diccionarioMorse.put("..", "I");
        diccionarioMorse.put(".---", "J");
        diccionarioMorse.put("-.-", "K");
        diccionarioMorse.put(".-..", "L");
        diccionarioMorse.put("--", "M");
        diccionarioMorse.put("-.", "N");
        diccionarioMorse.put("--.--", "Ñ");
        diccionarioMorse.put("---", "O");
        diccionarioMorse.put(".--.", "P");
        diccionarioMorse.put("--.-", "Q");
        diccionarioMorse.put(".-.", "R");
        diccionarioMorse.put("...", "S");
        diccionarioMorse.put("-", "T");
        diccionarioMorse.put("..-", "U");
        diccionarioMorse.put("...-", "V");
        diccionarioMorse.put(".--", "W");
        diccionarioMorse.put("-..-", "X");
        diccionarioMorse.put("-.--", "Y");
        diccionarioMorse.put("--..", "Z");
        diccionarioMorse.put("-----", "0");
        diccionarioMorse.put(".----", "1");
        diccionarioMorse.put("..---", "2");
        diccionarioMorse.put("...--", "3");
        diccionarioMorse.put("....-", "4");
        diccionarioMorse.put(".....", "5");
        diccionarioMorse.put("-....", "6");
        diccionarioMorse.put("--...", "7");
        diccionarioMorse.put("---..", "8");
        diccionarioMorse.put("----.", "9");
        diccionarioMorse.put(".-.-.-", ".");
        diccionarioMorse.put("--..--", ",");
        diccionarioMorse.put("---...", ":");
        diccionarioMorse.put("..--..", "?");
        diccionarioMorse.put(".----.", "'");
        diccionarioMorse.put("-....-", "-");
        diccionarioMorse.put("-..-.", "/");
        diccionarioMorse.put(".-..-.", "\"");
        diccionarioMorse.put(".--.-.", "@");
        diccionarioMorse.put("-...-", "=");
        diccionarioMorse.put("−.−.−−", "!");

        StringBuilder finalstring = new StringBuilder();
        String[] morsePalabrasArray =  morse.split("   ");
        for (String palabra : morsePalabrasArray) {
            String[] morseArray =  palabra.split(" ");
            for (String s : morseArray) {
                finalstring.append(diccionarioMorse.get(s));
            }
            finalstring.append(" ");
        }
        return finalstring.toString().trim();
    }
}

