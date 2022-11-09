package com.example.MorseController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {

    private Map<String, Character> diccionarioMorse = new HashMap<>();

    public MorseController() {
        diccionarioMorse.put(".-", 'A');
        diccionarioMorse.put("-...", 'B');
        diccionarioMorse.put("-.-.", 'C');
        diccionarioMorse.put("-..", 'D');
        diccionarioMorse.put(".", 'E');
        diccionarioMorse.put("..-.", 'F');
        diccionarioMorse.put("--.", 'G');
        diccionarioMorse.put("....", 'H');
        diccionarioMorse.put("..", 'I');
        diccionarioMorse.put(".---", 'J');
        diccionarioMorse.put("-.-", 'K');
        diccionarioMorse.put(".-..", 'L');
        diccionarioMorse.put("--", 'M');
        diccionarioMorse.put("-.", 'N');
        diccionarioMorse.put("---", 'O');
        diccionarioMorse.put(".--.", 'P');
        diccionarioMorse.put("--.-", 'Q');
        diccionarioMorse.put(".-.", 'R');
        diccionarioMorse.put("...", 'S');
        diccionarioMorse.put("-", 'T');
        diccionarioMorse.put("..-", 'U');
        diccionarioMorse.put("...-", 'V');
        diccionarioMorse.put(".--", 'W');
        diccionarioMorse.put("-..-", 'X');
        diccionarioMorse.put("-.--", 'Y');
        diccionarioMorse.put("--..", 'Z');
        diccionarioMorse.put(" ", ' ');
    }

    @GetMapping("/morse/{code}")
    public String morse(@PathVariable String code) {
        String res = "";
        String[] palabras = code.split("   ");


        System.out.println(palabras);
        for(String palabra : palabras) {

            ArrayList<String> letras = new ArrayList<String>(Arrays.asList(palabra.split(" ")));

            String s = letras.stream()
                    .map(letra -> diccionarioMorse.get(letra).toString())
                    .reduce("", String::concat);
            res += s + " ";
        }
        System.out.println(res);
        return res.substring(0, res.length() - 1);
    }

}