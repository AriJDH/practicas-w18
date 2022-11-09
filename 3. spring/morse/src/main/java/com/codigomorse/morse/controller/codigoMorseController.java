package com.codigomorse.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class codigoMorseController {

    @GetMapping("/codigo/{mensaje}")
    public String decodificar (@PathVariable String mensaje){
        String rta = " ";
        int num =0;
        Map<String, String> morse = new HashMap<String,String>();
        String [] codigo ={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",
                ".....","-....","--...","---..","----.","..--..","-.-.--",".-.-.-","--..--"};


        for (int i=0; i<26;i++){
            int letra = 65;
            morse.put(String.valueOf((char)(letra+i)),codigo[i]);
        }
        for (int j=26; j<36;j++){
            morse.put(String.valueOf(num),codigo[j]);
            num++;
        }

        morse.put(String.valueOf("?"),codigo[36]);
        morse.put(String.valueOf("!"),codigo[37]);
        morse.put(String.valueOf("."),codigo[38]);
        morse.put(String.valueOf(","),codigo[39]);

        String [] palabras = mensaje.split("   ");

        for(int x=0; x<palabras.length; x++){
            String[] letras = palabras[x].split(" ");
            for(int y=0; y<letras.length; y++){
                for(Map.Entry<String,String> m: morse.entrySet()){
                        if(letras[y].compareTo(m.getValue())==0)
                            rta+=m.getKey();
                }
            }
            rta+=" ";
        }


        return rta;
    }
}
