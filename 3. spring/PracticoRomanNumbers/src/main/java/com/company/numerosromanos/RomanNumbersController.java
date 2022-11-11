package com.company.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumbersController {

    @GetMapping("/{number}")
    public String convertRomanNumbers(@PathVariable Integer number) {
        String[] romanNumbers = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabicNumbers = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (number > 0 || arabicNumbers.length == (i - 1)) {
            while ((number - arabicNumbers[i]) >= 0) {
                number -= arabicNumbers[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }
        return result.toString();
    }
}