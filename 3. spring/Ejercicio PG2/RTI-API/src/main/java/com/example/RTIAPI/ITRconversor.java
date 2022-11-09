package com.example.RTIAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.TreeMap;

@RestController
public class ITRconversor {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    @GetMapping
    public String ITR(){
        return "Conversor numero entero a romano, inserte un numero entero en la URL " +
                "de la forma localhost:8080/i siendo i su numero para convertir (Valido hasta 3999)";
    }

    @GetMapping("/{i}")
    public String ITR(@PathVariable int i){
        return ITRAux(i);
    }

    public final static String ITRAux(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + ITRAux(number-l);
    }

}
