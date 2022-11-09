package com.example.numerosromanos.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConverterService {

    public static Map<String, Integer> map = new LinkedHashMap<String,Integer>();

    public String romanize(int value){
        String result = "";
        int number = value;
        while(number > 0){
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while(((Iterator<?>) it).hasNext()){
                Map.Entry<String, Integer> entry = it.next();
                if(number >= entry.getValue()){
                    number -= entry.getValue();
                    result += entry.getKey();
                    break;
                }
            }
        }
        return result;
    }

    public static void populateMap(){
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }
}
