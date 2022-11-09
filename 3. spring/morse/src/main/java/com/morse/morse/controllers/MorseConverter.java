package com.morse.morse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseConverter {

    @GetMapping("morse/{morseCode}")
    public static String morseToEnglish( @PathVariable String morseCode)
    {

        String[] code
                = { ".-",   "-...", "-.-.", "-..",  ".",
                "..-.", "--.",  "....", "..",   ".---",
                "-.-",  ".-..", "--",   "-.",   "---",
                ".--.", "--.-", ".-.",  "...",  "-",
                "..-",  "...-", ".--",  "-..-", "-.--",
                "--..", "|"};

        String[] array = morseCode.split("\\s{1,1}");
        String palabra = "";

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            for (int j = 0; j < code.length; j++) {
                if (array[i].compareTo(code[j]) == 0) {
                    palabra = palabra + (char) (j + 'a');
                }
                if(array[i].compareTo("") == 0){
                    palabra = palabra + " ";
                }
            }
        }
        return palabra;
    }
}
