package com.apimorse.EjercicioMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
    @GetMapping("/{claveMorse}")

    public static String traductor(@PathVariable String claveMorse) {

        String[] palabrasClave = claveMorse.split("  ");  //Separa las palabras de la clave, cuando tienen dos espacios

        if (palabrasClave.length == 0) {
            return "";
        }


        StringBuilder textoCodificado = new StringBuilder();  //Aqui se guardará la frase

        for (int i = 0; i < palabrasClave.length; i++) { //Recorre las palabras en código
            String word = palabrasClave[i];
            if (word.isEmpty())
                continue;
            String[] caracteres = word.split(" ");  //separa cada palabra en sus caracteres

            for (String character : caracteres) { //Recorre la lista de caracteres
                textoCodificado.append(decodeLetter(character)); //Cambia cada caracter al texto y lo guarda en la frase
            }
            if (i != palabrasClave.length - 1) //Al final de cada palabra, guarda un espacio.
                textoCodificado.append(" ");
        }
        return textoCodificado.toString();
    }

    private static String decodeLetter(String word) {  //Los casos de las letras
        String result = "";
        switch (word) {
            case ".-.-.-":
                result = ".";
                break;
            case "-.-.--":
                result = "!";
                break;
            case "···−−−···":
                result = "SOS";
                break;
            case ".-":
                result = "A";
                break;
            case "-...":
                result = "B";
                break;
            case "-.-.":
                result = "C";
                break;
            case "-..":
                result = "D";
                break;
            case ".":
                result = "E";
                break;
            case "..-.":
                result = "F";
                break;
            case "--.":
                result = "G";
                break;
            case "....":
                result = "H";
                break;
            case "..":
                result = "I";
                break;
            case ".---":
                result = "J";
                break;
            case "-.-":
                result = "K";
                break;
            case ".-..":
                result = "L";
                break;
            case "--":
                result = "M";
                break;
            case "-.":
                result = "N";
                break;
            case "---":
                result = "O";
                break;
            case ".--.":
                result = "P";
                break;
            case "--.-":
                result = "Q";
                break;
            case ".-.":
                result = "R";
                break;
            case "...":
                result = "S";
                break;
            case "-":
                result = "T";
                break;
            case "..-":
                result = "U";
                break;
            case "...-":
                result = "V";
                break;
            case ".--":
                result = "W";
                break;
            case "-..-":
                result = "X";
                break;
            case "-.--":
                result = "Y";
                break;
            case "--..":
                result = "Z";
                break;
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
                break;
        }
        return result;
    }
}

