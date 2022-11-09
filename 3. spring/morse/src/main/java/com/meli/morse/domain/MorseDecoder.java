package com.meli.morse.domain;

import java.util.HashMap;
import java.util.Map;

public class MorseDecoder {
    private Map<String, Character> dict;
    public MorseDecoder(){
        dict= new HashMap<>();
        dict.put( ".-", 'A');
        dict.put("-...", 'B');
        dict.put("-.-.", 'C');
        dict.put("-..", 'D');
        dict.put(".", 'E');
        dict.put("..-.",'F');
        dict.put("--.",'G');
        dict.put("....",'H');
        dict.put("..",'I');
        dict.put(".---",'J');
        dict.put("-.-",'K');
        dict.put("-.-", 'K');
        dict.put(".-..",'L');
        dict.put("--",'M');
        dict.put("-.",'N');
        dict.put("---",'O');
        dict.put(".--.",'P');
        dict.put("--.-",'Q');
        dict.put(".-.", 'R');
        dict.put("...",'S');
        dict.put("-", 'T');
        dict.put("..-",'U');
        dict.put("...-",'V');
        dict.put(".--",'W');
        dict.put("-..-",'X');
        dict.put("-.--",'Y');
        dict.put("--..",'Z');
        //y más pero no me gusta cargar datos(?
    }

    public String decode(String morseString){
        String[] words = morseString.split("   ");
        String result="";
        for(String word: words){
            String[] characters = word.split(" ");
            for(String character: characters){
                Character decodedChar = dict.get(character);
                if(decodedChar!=null)
                    result+= dict.get(character);
                else
                    return "El mensaje no pudo ser decodificado";
            }
            result+=" ";
        }
        return result;
    }
}
