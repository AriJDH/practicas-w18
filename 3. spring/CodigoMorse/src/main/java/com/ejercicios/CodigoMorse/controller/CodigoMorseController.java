package com.ejercicios.CodigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    @GetMapping("/{codigo}")
    public String convertirMensaje(@PathVariable String codigo){

        Map<String, String> diccionarioMorse = new HashMap<>();

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
        diccionarioMorse.put("", " ");

        String[] words = codigo.split("   ");
        if (words.length == 0) {
            return "";
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            if (word.isEmpty()) continue;
            String[] characters = word.split(" ");
            for (String character : characters){
                stringBuffer.append(diccionarioMorse.get(character));
            }
            if (i != words.length - 1) stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}




