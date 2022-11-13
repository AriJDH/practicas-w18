package com.example.codigoMorseNew;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseNewController {
    @GetMapping("decode/{morseCode}")
    public String decode(@PathVariable String morseCode) {
        String[] palabras = morseCode.split("   ");

        StringBuilder stringBuffer = new StringBuilder();

        for (int i = 0; i < palabras.length; i++) {
            String palabraIndividual = palabras[i];//Tomo la palabra correspondiente a una posicion
            String[] caracter = palabraIndividual.split(" "); //Tomo letra por letra

            for (String c : caracter) {
                stringBuffer.append(diccionario(c));
            }
                stringBuffer.append(" "); //espacio para separar palabras
        }
        return stringBuffer.toString();
    }

    private static String diccionario(String valor) {
        String traducido = "";
        Map<String, String> diccionarioMap = new HashMap<>();

        diccionarioMap.put("A", ".-");
        diccionarioMap.put("B", "-...");
        diccionarioMap.put("C", "-.-.");
        diccionarioMap.put("D", "-..");
        diccionarioMap.put("E", ".");
        diccionarioMap.put("F", "..-.");
        diccionarioMap.put("G", "--.");
        diccionarioMap.put("H", "....");
        diccionarioMap.put("I", "..");
        diccionarioMap.put("J", ".---");
        diccionarioMap.put("K", "-.-");
        diccionarioMap.put("L", ".-..");
        diccionarioMap.put("M", "--");
        diccionarioMap.put("N", "-.");
        diccionarioMap.put("O", "---");
        diccionarioMap.put("P", ".--.");
        diccionarioMap.put("Q", "--.-");
        diccionarioMap.put("R", ".-.");
        diccionarioMap.put("S", "...");
        diccionarioMap.put("T", "-");
        diccionarioMap.put("U", "..-");
        diccionarioMap.put("V", "...-");
        diccionarioMap.put("W", ".--");
        diccionarioMap.put("X", "-..-");
        diccionarioMap.put("Y", "-.--");
        diccionarioMap.put("Z", "--..");

        for (Map.Entry v: diccionarioMap.entrySet()) {
            if(v.getValue().equals(valor)){
              traducido =  (String) v.getKey();
            }
        }
/*
            case ".----":
                result = "1";
                break;
            case "..---":
                result = "2";
                break;
            case "...--":
                result = "3";
                break;
            case "....-":
                result = "4";
                break;
            case ".....":
                result = "5";
                break;
            case "_....":
                result = "6";
                break;
            case "__...":
                result = "7";
                break;
            case "___..":
                result = "8";
                break;
            case "____.":
                result = "9";
                break;
            case "_____":
                result = "0";
                break;
            default:
                break;*/
        return traducido;
    }

}

