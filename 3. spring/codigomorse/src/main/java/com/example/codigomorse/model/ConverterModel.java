package com.example.codigomorse.model;

public class ConverterModel {

    private String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0","!", ",", "?", ".", "'"};
    private String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----","-.-.--", "--..--", "..--..", ".-.-.-", ".----."};

    public ConverterModel(){}

    public String decode(String morsecode) {
        String toReturn = "";

        String[] words = morsecode.split("  ");

        for(String word: words){
            String[] letterInMorse = word.split(" ");

            for(String letter: letterInMorse){
                for(int i = 0; i < morse.length; i++){
                    if(letter.equals(morse[i])){
                        toReturn += alphabet[i].toUpperCase();
                    }
                }
            }
            toReturn += " ";
        }
        return toReturn;
    }
}
