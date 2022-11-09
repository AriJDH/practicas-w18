package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NroRomano {
    @GetMapping("convertirARomano/{nro}")
    public String convertirARomano(@PathVariable Integer nro){
        int m;
        String unidad[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String decena[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String centena[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String miles = "";

        int resto = nro;
        m = resto / 1000;
        resto = resto % 1000;

        int c = resto / 100;
        resto = resto % 100;

        int d = resto / 10;
        resto = resto % 10;

        int u = resto;
        for (int i = 1; i <= m; i++) {
            miles += "M";
        }
        if (nro >= 1000) {
            return miles + centena[c] + decena[d] + unidad[u];
        } else if (nro >= 100) {
            return centena[c] + decena[d] + unidad[u];
        } else {
            if (nro >= 10) {
                return decena[d] + unidad[u];
            } else {
                return unidad[nro];
            }
        }
    }
}
