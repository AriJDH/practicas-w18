package com.example.CodigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CodigoMorseController {

    //SOLUCIÓN 1. MESA DE TRABAJO
    @GetMapping("/{codigoIngresado}")
    public String traductor(@PathVariable String codigoIngresado) {
        String[] ascii = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?", "!", ":", "@", "=", "-", "+", "\"", "/", "&",
                "'", "(", ")", "ñ"};

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--..", "-.-.--", "---...", ".--.-.",
                "-...-", "-....-", ".-.-.", ".-..-.", "-..-.", ".-...", ".----.",
                "-.--.", "-.--.-", "--.--"};

        Map<String, String> equivalencias = new HashMap<>();

        String traduccion = "";

        for (int i = 0; i < ascii.length; i++) {
            equivalencias.put(ascii[i], morse[i]);
        }
        //Separo las palabras del Código Morse
        String[] palabrasMorse = codigoIngresado.split("   ");
        int i=0;
        //Recorro las palabras del Código Morse
        for (String palabraMorse : palabrasMorse) {
            //Separo las letras de cada palabra del Código Morse
            String[] letrasPalabra = palabraMorse.split(" ");
            //Recorro las letras y comparo
            for (String letra : letrasPalabra) {
                for (Map.Entry<String, String> equivalencia : equivalencias.entrySet()) {
                    if (equivalencia.getValue().equals(letra)) {
                        //Inserto la traducción
                        traduccion += equivalencia.getKey();
                    }
                }
            }
            //Agrego un espacio después de cada palabra traducida
            if(i<palabrasMorse.length - 1){
                traduccion+=" ";
            }
            i++;
        }
        return traduccion;
    }

  //SOLUCIÓN 2. UTILIZO STREAM
/*@GetMapping("/{codigo}")
public String traductor(@PathVariable String codigo){
    return convertir(codigo);
}

    private static final String[] ascii = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?", "!", ":", "@", "=", "-", "+", "\"", "/", "&",
            "'", "(", ")", "ñ"};

    private static final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--..", "-.-.--", "---...", ".--.-.",
            "-...-", "-....-", ".-.-.", ".-..-.", "-..-.", ".-...", ".----.",
            "-.--.", "-.--.-", "--.--"};

    private static final Map<String,String> equivalencias = new HashMap<>();

    static {
        for (int i = 0; i < ascii.length; i++) {
            equivalencias.put(morse[i], ascii[i]);
        }
    }

    private static String convertir(String codigo){
        return Arrays.stream(codigo.trim().toUpperCase().split("   ")).map(CodigoMorseController::crearPalabra).collect(Collectors.joining(" "));
    }

    private static String crearPalabra(String palabra){
        return Arrays.stream(palabra.split(" ")).map(equivalencias::get).collect(Collectors.joining(""));
    }*/

}
