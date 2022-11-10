package com.mercadolibre.morse.service;

import java.util.HashMap;
import java.util.Map;

public class CodigoMorseService {
    private Map<String,String> MORSE;

    public CodigoMorseService() {
        MORSE = new HashMap<>();
        MORSE.put(".-","A");
        MORSE.put("-...","B");
        MORSE.put("-.-.","C");
        MORSE.put("-..","D");
        MORSE.put(".","E");
        MORSE.put("..-.","F");
        MORSE.put("--.","G");
        MORSE.put("....","H");
        MORSE.put("..","I");
        MORSE.put(".---","J");
        MORSE.put("-.-","K");
        MORSE.put(".-..","L");
        MORSE.put("--","M");
        MORSE.put("-.","N");
        MORSE.put("---","O");
        MORSE.put(".--.","P");
        MORSE.put("--.-","Q");
        MORSE.put(".-.","R");
        MORSE.put("...","S");
        MORSE.put("-","T");
        MORSE.put("..-","U");
        MORSE.put("...-","V");
        MORSE.put(".--","W");
        MORSE.put("-..-","X");
        MORSE.put("-.--","Y");
        MORSE.put("--..","Z");
        MORSE.put("..--..","?");
        MORSE.put("-.-.--","!");
        MORSE.put(".-.-.-",".");
        MORSE.put("--..--",",");
        MORSE.put(".----","1");
        MORSE.put("..---","2");
        MORSE.put("...--","3");
        MORSE.put("....-","4");
        MORSE.put(".....","5");
        MORSE.put("-....","6");
        MORSE.put("--...","7");
        MORSE.put("---..","8");
        MORSE.put("----.","9");
        MORSE.put("-----","0");
        MORSE.put("···−−−···","SOS");
    }

    public String traducirCodigoMorse(String codigo) {
        String[] palabras = codigo.split("   ");
        String traduccion = "";
        for (String p : palabras) {
            String[] letras = p.split(" ");
            for (String letra: letras) {
                traduccion+= MORSE.get(letra);
            }
            traduccion = traduccion + " ";
        }
        return traduccion;
    }
    
}
