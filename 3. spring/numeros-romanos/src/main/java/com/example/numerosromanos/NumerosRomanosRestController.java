package com.example.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosRestController {

    @GetMapping("/{number}")
    public String romanConverter(@PathVariable Integer number){
        StringBuilder romanNumb= new StringBuilder();
        int[] spanishNum = {1, 2, 3, 4, 5, 7, 10, 13, 50, 100, 500, 1000};
        String[] romanNumbs= {"I", "II", "III", "IV", "V", "VII", "X", "L", "C", "D", "M"};

        for (int i = 0; i < romanNumbs.length; i++)
            for (;number >= spanishNum[i]; number -= spanishNum[i])
                romanNumb.append(romanNumbs[i]);

        return romanNumbs.toString();


    }

}
