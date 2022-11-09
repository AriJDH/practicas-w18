package com.example.codigomorse.model;

import java.util.HashMap;

public abstract class TraductorMorse {
    private static HashMap<String, String> equivalencias= new HashMap<String, String>();

    static{
        equivalencias.put(".-.-.-",".");
        equivalencias.put("..--..","?");
        equivalencias.put("-.-.--","!");
        equivalencias.put("--..--",",");
        equivalencias.put(".-","A");
        equivalencias.put("-...","B");
        equivalencias.put("-.-.","C");
        equivalencias.put("-..","D");
        equivalencias.put(".","E");
        equivalencias.put("..-.","F");
        equivalencias.put("--.","G");
        equivalencias.put("....","H");
        equivalencias.put("..","I");
        equivalencias.put(".---","J");
        equivalencias.put("-.-","K");
        equivalencias.put(".-..","L");
        equivalencias.put("--","M");
        equivalencias.put("-.","N");
        equivalencias.put("---","O");
        equivalencias.put(".--.","P");
        equivalencias.put("--.-","Q");
        equivalencias.put(".-.","R");
        equivalencias.put("...","S");
        equivalencias.put("-","T");
        equivalencias.put("..-","U");
        equivalencias.put("...-","V");
        equivalencias.put(".--","W");
        equivalencias.put("-..-","X");
        equivalencias.put("-.--","Y");
        equivalencias.put("--..","Z");
        equivalencias.put(".----","1");
        equivalencias.put("..---","2");
        equivalencias.put("...--","3");
        equivalencias.put("....-","4");
        equivalencias.put(".....","5");
        equivalencias.put("_....","6");
        equivalencias.put("__...","7");
        equivalencias.put("___..","8");
        equivalencias.put("____.","9");
        equivalencias.put("_____","0");
    }

    public static String traducirMorseATexto(String strMorse){
        String[] palabrasMorse = strMorse.split("   ");
        String textoTraducido = "";

        for (String palabraMorse:palabrasMorse) {
            String[] letrasMorse = palabraMorse.split(" ");

            for(String letraMorse: letrasMorse){
                textoTraducido += equivalencias.containsKey(letraMorse)? equivalencias.get(letraMorse):"[¿?]";
            }

            textoTraducido += " ";
        }
        return textoTraducido;
    }
}
