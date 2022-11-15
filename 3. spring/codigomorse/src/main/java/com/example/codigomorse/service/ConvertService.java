package com.example.codigomorse.model;

public class Model {

    private String[] alfabeto = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0","!", ",", "?", ".", "'"};
    private String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----","-.-.--", "--..--", "..--..", ".-.-.-", ".----."};

    public Model() {

    }

    public String decodificar(String codigoMorse){
        String frase = "";

        String[] palabras = codigoMorse.split("  ");

        for(String palabra: palabras){
            String[] letrasEnMorse = palabra.split(" ");

            for(String letraDelCodigo: letrasEnMorse){
                for(int i = 0; i < morse.length; i++){
                    if(letraDelCodigo.equals(morse[i])){
                        frase += alfabeto[i].toUpperCase();
                    }
                }
            }

            frase += " ";
        }

        return frase;
    }
}
