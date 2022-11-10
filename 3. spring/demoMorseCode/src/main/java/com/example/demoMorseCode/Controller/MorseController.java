package com.example.demoMorseCode.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {
    @GetMapping("/{morseCode}")
    public String decode(@PathVariable String morseCode) {
        String[] words = morseCode.split("   ");
        if (words.length == 0) {
            return "";
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty())
                continue;
            String[] characters = word.split(" ");
            for (String character : characters) {
                stringBuffer.append(decodeLetter(character));
            }
            if (i != words.length - 1)
                stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    private static String decodeLetter(String word) {
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
