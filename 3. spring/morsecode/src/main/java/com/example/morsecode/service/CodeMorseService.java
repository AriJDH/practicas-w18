package com.example.morsecode.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;


@Service
public class CodeMorseService {

    private char alfanum[]={'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '?', '!', '.', ',', ' '};
    private String morseCode[]={"._","_...","_._.","_..",".",".._.","__.","....","..",".___","_._","._..","__","_.",
            "___",".__.","__._","._.","...","_",".._","..._",".__","_.._","_.__","__..",".____","..___","...__","....",
            ".....","_....","__...","___..","____.","_____","..__..","_._.__","._._._","__..__"," "};


   private Map<String, String> codigos = new HashMap<>();
   private Map<String, String> equivalencias = new HashMap<>();

    public void setCodigos() {
        codigos.put(".-", "A");
        codigos.put("-...", "B");
        codigos.put("-.-.", "C");
        codigos.put("-..", "D");
        codigos.put(".", "E");
        codigos.put("..-.", "F");
        codigos.put("--.", "G");
        codigos.put("....", "H");
        codigos.put("..", "I");
        codigos.put(".---", "J");
        codigos.put("-.-", "K");
        codigos.put(".-..", "L");
        codigos.put("--", "M");
        codigos.put("-.", "N");
        codigos.put("---", "O");
        codigos.put(".--.", "P");
        codigos.put("--.-", "Q");
        codigos.put(".-.", "R");
        codigos.put("...", "S");
        codigos.put("-", "T");
        codigos.put("..-", "U");
        codigos.put("...-", "V");
        codigos.put(".--", "W");
        codigos.put("-..-", "X");
        codigos.put("-.--", "Y");
        codigos.put("--..", "Z");
        codigos.put(".----", "1");
        codigos.put("..---", "2");
        codigos.put("...--", "3");
        codigos.put("....-", "4");
        codigos.put(".....", "5");
        codigos.put("-....", "6");
        codigos.put("--...", "7");
        codigos.put("---..", "8");
        codigos.put("----.", "9");
        codigos.put("-----", "0");
        codigos.put("..--..", "?");
        codigos.put(".-.-.-", ".");
        codigos.put(".-.-.-", ".");
        codigos.put("--..--", ",");
        codigos.put(" ", " ");
    }

    public void setEquivalencias() {
        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("CH", "----");
        equivalencias.put("D", "-..");
        equivalencias.put("E", ".");
        equivalencias.put("F", "..-.");
        equivalencias.put("G", "--.");
        equivalencias.put("H", "....");
        equivalencias.put("I", "..");
        equivalencias.put("J", ".---");
        equivalencias.put("K", "-.-");
        equivalencias.put("L", ".-..");
        equivalencias.put("M", "--");
        equivalencias.put("N", "-.");
        equivalencias.put("Ñ", "--.--");
        equivalencias.put("O", "---");
        equivalencias.put("P", ".--.");
        equivalencias.put("Q", "--.-");
        equivalencias.put("R", ".-.");
        equivalencias.put("S", "...");
        equivalencias.put("T", "-");
        equivalencias.put("U", "..-");
        equivalencias.put("V", "...-");
        equivalencias.put("W", ".--");
        equivalencias.put("X", "-..-");
        equivalencias.put("Y", "-.--");
        equivalencias.put("Z", "--..");
        equivalencias.put("0", "-----");
        equivalencias.put("1", ".----");
        equivalencias.put("2", "..---");
        equivalencias.put("3", "...--");
        equivalencias.put("4", "....-");
        equivalencias.put("5", ".....");
        equivalencias.put("6", "-....");
        equivalencias.put("7", "--...");
        equivalencias.put("8", "---..");
        equivalencias.put("9", "----.");
        equivalencias.put(".", ".-.-.-");
        equivalencias.put(",", "--..--");
        equivalencias.put("?", "..--..");
        equivalencias.put("!", "−.−.−−");
    }

    public String printFrase(String morse){
        setEquivalencias();
        String fras ="";
            for (int j = 0; j < morse.length(); j ++){
                fras= fras+equivalencias.get(String.valueOf(morse.charAt(j)).toUpperCase());
            }
        System.out.println(fras);

        return fras;
    }
    public String printCodeMorse(String frase){
        setCodigos();
        String cMorse="";
        List<String> listMorse= Arrays.asList(frase.split(" "));
        for (String code : listMorse) {
            cMorse+=codigos.get(code);
        }
        return cMorse;
    }
}
