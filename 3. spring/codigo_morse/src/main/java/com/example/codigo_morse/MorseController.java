package com.example.codigo_morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {
    @GetMapping("/morse/{codigo}")
    public String morse(@PathVariable String codigo){
        String decodificado = "";
        String[] parts = codigo.split(" ");

        Map<String, Character> morse = new HashMap<String, Character>();
        morse.put(".-", 'A');
        morse.put("-...", 'B');
        morse.put( "-.-.", 'C');
        morse.put( "-..", 'D');
        morse.put(   ".", 'E');
        morse.put("..-.", 'F');
        morse.put( "--.", 'G');
        morse.put("....", 'H');
        morse.put(  "..", 'I');
        morse.put(".---", 'J');
        morse.put(  "-.", 'K');
        morse.put(".-..", 'L');
        morse.put(  "--", 'M');
        morse.put(  "-.", 'N');
        morse.put( "---", 'O');
        morse.put(".--.", 'P');
        morse.put("--.-", 'Q');
        morse.put(".-.", 'R');
        morse.put( "...", 'S');
        morse.put(  "-", 'T');
        morse.put( "..-", 'U');
        morse.put("...-", 'V');
        morse.put( ".--", 'W');
        morse.put("-..-", 'X');
        morse.put("-.--", 'Y');
        morse.put("--..", 'Z');
        morse.put(".----", '1');
        morse.put("..---", '2');
        morse.put("...--", '3');
        morse.put("....-", '4');
        morse.put(".....", '5');
        morse.put("-....", '6');
        morse.put("--...", '7');
        morse.put("---..", '8');
        morse.put("----.", '9');
        morse.put("-----", '0');

        for (String palabra: parts
        ) {
            decodificado = decodificado + morse.get(palabra);
        }

        return decodificado;
    }
}
