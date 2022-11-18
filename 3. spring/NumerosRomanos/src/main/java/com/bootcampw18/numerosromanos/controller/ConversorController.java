package com.bootcampw18.numerosromanos.controller;

import com.bootcampw18.numerosromanos.service.Conversor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/conversor")
@Slf4j
public class ConversorController {
    private Conversor conversor = new Conversor();

    @GetMapping("/romano-decimal/{nroRomano}")
    public Integer convertirNroRomanoADecimal(@PathVariable String nroRomano){
        log.info("Convirtiendo "+ nroRomano);
        return conversor.convertirNroRomanoADecimal(nroRomano);
    }
    @GetMapping("/decimal-romano/{nroDecimal}")
    public String convertirNroDecimalARomano(@PathVariable Integer nroDecimal){
        return conversor.convertirNroDecimalARomano(nroDecimal);
    }
    @GetMapping("/{number}")
    public String toRoman(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }

}
