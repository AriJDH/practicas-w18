package com.dh.demo.api.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    public String getMorseCode(String code){

        String[] codes
                = { ".-",   "-...", "-.-.", "-..",  ".",
                "..-.", "--.",  "....", "..",   ".---",
                "-.-",  ".-..", "--",   "-.",   "---",
                ".--.", "--.-", ".-.",  "...",  "-",
                "..-",  "...-", ".--",  "-..-", "-.--",
                "--..", "|" };

        Map<String, Character> morse = new HashMap<String, Character>();
        for (int i = 0; i < codes.length; i++) {
            morse.put(codes[i], (char)('a' + i));
        }

        String decoded = "";
        String[] arr = code.split(" ");
        for (int i = 0; i < arr.length; i++) {
            decoded += morse.get(arr[i]);
        }
        return decoded;
    }

}
