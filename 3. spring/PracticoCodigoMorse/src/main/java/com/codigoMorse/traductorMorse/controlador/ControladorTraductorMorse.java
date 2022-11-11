package com.codigoMorse.traductorMorse.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ControladorTraductorMorse {

    @GetMapping("/{codigoMorse}")
    public String traducir(@PathVariable String codigoMorse){
        HashMap<Character, String> morse = new HashMap<Character, String>();

        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c',  "-.-.");
        morse.put('d',  "-..");
        morse.put('e',    ".");
        morse.put('f', "..-.");
        morse.put('g',  "--.");
        morse.put('h', "....");
        morse.put('i',   "..");
        morse.put('j', ".---");
        morse.put('k',   "-.");
        morse.put('l', ".-..");
        morse.put('m',   "--");
        morse.put('n',   "-.");
        morse.put('o',  "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s',  "...");
        morse.put('t',   "-");
        morse.put('u',  "..-");
        morse.put('v', "...-");
        morse.put('w',  ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");
        morse.put('1', ".----");
        morse.put('2',"..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        morse.put('?', "..--..");
        morse.put('!', "-.-.--");
        morse.put('.', ".-.-.-");
        morse.put(',', "--..--");
        String[] palabras = codigoMorse.split(" ");
        String traduccion ="";

        for(String palabra : palabras){
            for(Map.Entry<Character, String> entry: morse.entrySet()){
                if(entry.getValue().equals(palabra)){
                    traduccion += (entry.getKey().toString());
                }
            }

        }
        return traduccion;
    }
}
