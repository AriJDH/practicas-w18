package com.example.demoRomanos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConvierteARomano {
    @GetMapping("/{numero}")
    public String convierteRomano(@PathVariable Integer numero){
        /*List<String> listaRomano =
                new ArrayList<String>(){{
                    add("I");
                    add("II");
                    add("III");
                    add("IV");
                    add("V");
                    add("VII");
                    add("X");
                    add("XIII");
                    add("L");
                    add("C");
                    add("D");
                    add("M");
                }};
        List<Integer> listaEnteros =
                new ArrayList<Integer>(){{
                    add(1);
                    add(2);
                    add(3);
                    add(4);
                    add(5);
                    add(7);
                    add(10);
                    add(13);
                    add(50);
                    add(100);
                    add(500);
                    add(1000);
                }};

        listaEnteros*/

        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;numero >= numbersToCompare[i]; numero -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();

    }
}
