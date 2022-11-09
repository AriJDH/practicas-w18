package com.example.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    @GetMapping("/{codigo}")
    public String mensaje(@PathVariable String codigo) {

        StringBuilder letra = new StringBuilder();
        Map<String, String> diccionario = new HashMap<>();
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("prueba");

        diccionario.put("A", ".-");
        diccionario.put("B", "-...");
        diccionario.put("C", "-.-.");
        diccionario.put("CH", "----");
        diccionario.put("D", "-..");
        diccionario.put("E", ".");
        diccionario.put("F", "..-.");
        diccionario.put("G", "--.");
        diccionario.put("H", "....");
        diccionario.put("I", "..");
        diccionario.put("J", ".---");
        diccionario.put("K", "-.-");
        diccionario.put("L", ".-..");
        diccionario.put("M", "--");
        diccionario.put("N", "-.");
        diccionario.put("Ñ", "--.--");
        diccionario.put("O", "---");
        diccionario.put("P", ".--.");
        diccionario.put("Q", "--.-");
        diccionario.put("R", ".-.");
        diccionario.put("S", "...");
        diccionario.put("T", "-");
        diccionario.put("U", "..-");
        diccionario.put("V", "...-");
        diccionario.put("W", ".--");
        diccionario.put("X", "-..-");
        diccionario.put("Y", "-.--");
        diccionario.put("Z", "--..");
        diccionario.put("0", "-----");
        diccionario.put("1", ".----");
        diccionario.put("2", "..---");
        diccionario.put("3", "...--");
        diccionario.put("4", "....-");
        diccionario.put("5", ".....");
        diccionario.put("6", "-....");
        diccionario.put("7", "--...");
        diccionario.put("8", "---..");
        diccionario.put("9", "----.");
        diccionario.put(".", ".-.-.-");
        diccionario.put(",", "--..--");
        diccionario.put(":", "---...");
        diccionario.put("?", "..--..");
        diccionario.put("'", ".----.");
        diccionario.put("-", "-....-");
        diccionario.put("/", "-..-.");
        diccionario.put("\"", ".-..-.");
        diccionario.put("@", ".--.-.");
        diccionario.put("=", "-...-");
        diccionario.put("!", "−.−.−−");
        diccionario.put(" ", "%20");


        for (int i = 0; i < codigo.length(); i++) {

            if (codigo.charAt(i) != ' ') {
                System.out.println("Hola");
                letra.append(codigo.charAt(i));
            } else if (codigo.charAt(i) == '%' || i == codigo.length()-1) {
                for (String key : diccionario.keySet()) {
                    if (letra.toString().equals(key.toString())) {
                        mensaje.append(key);
                    }
                }
                letra = new StringBuilder();
                 if(i+2 < codigo.length() && codigo.charAt(i+2) == ' ' && codigo.charAt(i+1) == ' ' && i+1 < codigo.length() ){
                    mensaje.append(" ");
                }

            }


        }

        return mensaje.toString();
    }
}
