package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map.Entry;

@RestController
public class CodeMorse {
    @GetMapping("morse/{str}")
    public String hello(@PathVariable String str){
        String[] strSplit = str.split("   ");

        HashMap<String, String> equi = equivalencias();
        String newStr = "";

        for(String s : strSplit){
        String[] c = s.split(" ");
            newStr = newStr.length() > 0 ? newStr + " " : "";
            for(String ch : c){
            String value = equi.get(ch);
            newStr += value;
        }
        }

        return  newStr;
    }


    public HashMap<String,String> equivalencias(){
        HashMap<String, String> morse = new HashMap<>();
        morse.put( ".-", "A");
        morse.put( "-...","B");
        morse.put( "-.-.", "C");
        morse.put( "-..","D");
        morse.put(   ".","E");
        morse.put("..-.","F");
        morse.put( "--.", "G");
        morse.put("....", "H");
        morse.put("..","I");
        morse.put(".---","J");
        morse.put( "-.-","K");
        morse.put(".-..","L");
        morse.put("--","M");
        morse.put("-.","N");
        morse.put("---", "O");
        morse.put(".--.","P");
        morse.put("--.-", "Q");
        morse.put(".-.", "R");
        morse.put( "...", "S");
        morse.put("-", "T");
        morse.put("..-", "U");
        morse.put("...-", "V");
        morse.put(".--", "W");
        morse.put("-..-", "X");
        morse.put("-.--", "Y");
        morse.put("--..", "Z");
        return morse;
    }
}
