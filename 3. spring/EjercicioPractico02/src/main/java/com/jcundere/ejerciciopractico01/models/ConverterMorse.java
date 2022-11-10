package com.jcundere.ejerciciopractico01.models;

public class ConverterMorse {

    private static final String charsMorse[] = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--..",

            ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----",

            "..--..", "-.-.--", ".-.-.-", "--..--"
    };

    private static final String charsLatin[] = {
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z",

            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0",

            "?", "!", ".", ","
    };

    public static String decodificarCodigoMorse(String input){

        boolean isCorrect;
        StringBuilder msjResult = new StringBuilder();
        String[] palabras = input.split("   ");
        String[] letras;

        for (String palabra : palabras) {

            letras = palabra.split(" ");
            for (String letra : letras) {

                for (int k = 0; k < charsMorse.length; k++) {

                    if (letra.equals(charsMorse[k])) {
                        msjResult.append(charsLatin[k]);
                    }
                }
            }
            msjResult.append(" ");
        }

        return msjResult.toString();
    }

}
