package com.meli.introspringp2pg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class ConverterController {

    private static String units[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

    @GetMapping("/convert/{num}")
    public String convert(@PathVariable Integer num) {
        String thousands = "";
        int m;
        int n = num;
        int resto = n;
        m = resto / 1000;
        resto = resto % 1000;
        int c = resto / 100;
        resto = resto % 100;
        int d = resto / 10;
        resto = resto % 10;
        int u = resto;
        for (int i = 1; i <= m; i++) {
            thousands += "M";
        }
        if (n >= 1000) {
            return (thousands + hundreds[c] + tens[d] + units[u]);
        } else if (n >= 100) {
            return (hundreds[c] + tens[d] + units[u]);
        } else {
            if (n >= 10) {
                return (tens[d] + units[u]);
            } else {
                return (units[n]);
            }
        }
    }
}
