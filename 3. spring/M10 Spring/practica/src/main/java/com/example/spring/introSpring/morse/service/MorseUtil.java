package com.example.spring.introSpring.morse.service;

import org.springframework.stereotype.Service;

import java.util.Hashtable;


@Service
public class MorseUtil {


    public static Hashtable<String, String> equivalenciasMorseAscii(){
        Hashtable<String, String> morseCodeEquivalencias = new Hashtable<>();

        morseCodeEquivalencias.put("A", ".-");
        morseCodeEquivalencias.put("B", "-...");
        morseCodeEquivalencias.put("C", "-.-.");
        morseCodeEquivalencias.put("D", "-..");
        morseCodeEquivalencias.put("E", ".");
        morseCodeEquivalencias.put("F", "..-.");
        morseCodeEquivalencias.put("G", "--.");
        morseCodeEquivalencias.put("H", "....");
        morseCodeEquivalencias.put("I", "..");
        morseCodeEquivalencias.put("J", ".---");
        morseCodeEquivalencias.put("K", "-.-");
        morseCodeEquivalencias.put("L", ".-..");
        morseCodeEquivalencias.put("M", "--");
        morseCodeEquivalencias.put("N", "-.");
        morseCodeEquivalencias.put("O", "---");
        morseCodeEquivalencias.put("P", ".--.");
        morseCodeEquivalencias.put("Q", "--.-");
        morseCodeEquivalencias.put("R", ".-.");
        morseCodeEquivalencias.put("S", "...");
        morseCodeEquivalencias.put("T", "-");
        morseCodeEquivalencias.put("U", "..-");
        morseCodeEquivalencias.put("V", "...-");
        morseCodeEquivalencias.put("W", ".--");
        morseCodeEquivalencias.put("X", "-..-");
        morseCodeEquivalencias.put("Y", "-.--");
        morseCodeEquivalencias.put("Z", "--..");
        morseCodeEquivalencias.put("1", ".----");
        morseCodeEquivalencias.put("2", "..---");
        morseCodeEquivalencias.put("3", "...--");
        morseCodeEquivalencias.put("4", "....-");
        morseCodeEquivalencias.put("5", ".....");
        morseCodeEquivalencias.put("6", "-....");
        morseCodeEquivalencias.put("7", "--...");
        morseCodeEquivalencias.put("8", "---..");
        morseCodeEquivalencias.put("9", "----.");
        morseCodeEquivalencias.put("0", "-----");
        morseCodeEquivalencias.put("?", "..--..");
        morseCodeEquivalencias.put("!", "-.-.--");
        morseCodeEquivalencias.put(".", ".-.-.-");
        morseCodeEquivalencias.put(",", "--..--");

        return morseCodeEquivalencias;
    }


    public String convertirMorseAEspanol(String morse) {
        String conversion = "";


        return conversion;
    }
}
