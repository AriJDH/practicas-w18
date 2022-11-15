package com.example.romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {
    @GetMapping("/{num}")
    public String convertirDecimal(@PathVariable int num) {

        String Unidad[]={"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String Decena[]={"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String Centena[]={"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        int u = num % 10;
        int d = (num / 10) % 10;
        int c = num / 100;
        String numRomano = "";

        if (num >= 100){
            numRomano = Centena[c] + Decena[d] + Unidad[u];
        } else {
            if (num >= 10){
                numRomano = Decena[d] + Unidad[u];
            } else {
                numRomano = Unidad[num];
            }
        }

        return numRomano;
    }
}
