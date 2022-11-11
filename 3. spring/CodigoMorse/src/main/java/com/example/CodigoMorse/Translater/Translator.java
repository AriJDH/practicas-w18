package com.example.CodigoMorse.Translater;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class Translator {

    @GetMapping("/translator/{text}")
    public String morseToEsp(@PathVariable String text){

        String resul = "";
        String[] arr = text.split("   ");

        text.toLowerCase();
        HashMap<Character, String> morse = new HashMap();

        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c',  "-.-.");
        morse.put('d',  "-..");
        morse.put('e',    ".");
        morse.put('f', "..-.");
        morse.put('g',  "--.");
        morse.put('h', "....");
        morse.put('i',   "..");
        morse.put('j', ".---");
        morse.put('k',   "-.");
        morse.put('l', ".-..");
        morse.put('m',   "--");
        morse.put('n',   "-.");
        morse.put('o',  "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s',  "...");
        morse.put('t',   "-");
        morse.put('u',  "..-");
        morse.put('v', "...-");
        morse.put('w',  ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");
        morse.put('1', ".----");
        morse.put('2',"..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");

        //Creo un nuevo mapa con las keys y values invertidos
        Map<String, Character> newMap = morse.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (oldValue, newValue) -> newValue));

        //Itero por las palabras
        for(String x : arr){
            String[] temp = x.split(" ");
            //Itero por las "letras"
            for(String y : temp){
                resul += String.valueOf(newMap.get(y));
            }
            resul += " ";
        }
        return resul;
    }

}
