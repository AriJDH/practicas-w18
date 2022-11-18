package com.springP2.codMorse.services;

import java.util.HashMap;
import java.util.Map;

public class MorseDecoder {

    private Map<String, String> morseDictionary;

    private String[] english = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?"};

    private String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.."};

    public MorseDecoder() {
        morseDictionary = new HashMap<String, String>();
        for (int i = 0; i < english.length; ++i) {
            morseDictionary.put(morse[i], english[i]);
        }
    }

    public String decodificarMorse(String input) {
        String respuesta = "";
        System.out.println(input);
        String[] palabras = input.split("   ");
        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for (String letra : letras) {
                System.out.println(morseDictionary.get(letra));
                respuesta += morseDictionary.get(letra);
            }
        }
        return respuesta;
    }
}
