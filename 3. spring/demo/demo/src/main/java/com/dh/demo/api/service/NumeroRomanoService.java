package com.dh.demo.api.service;


import org.springframework.stereotype.Service;

@Service
public class NumeroRomanoService {

    public String getNumeroRomano(Integer num) {
        String[] m = { "", "M", "MM", "MMM" };
        String[] c = { "",  "C",  "CC",  "CCC",  "CD",
                "D", "DC", "DCC", "DCCC", "CM" };
        String[] x = { "",  "X",  "XX",  "XXX",  "XL",
                "L", "LX", "LXX", "LXXX", "XC" };
        String[] i = { "",  "I",  "II",  "III",  "IV",
                "V", "VI", "VII", "VIII", "IX" };
        String thousands = m[num / 1000];
        String hundreds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];
        return thousands + hundreds + tens + ones;
    }

}
