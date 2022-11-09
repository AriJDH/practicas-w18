package meli.bootcamp.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conversor
{
    @GetMapping("{cadena}")
    public String convertir(@PathVariable("cadena") int numero)
    {
        StringBuilder sb = new StringBuilder();
        int[] numerosEqui = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,  1};
        String[] letras = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        while (numero != 0)
        {
            for (int i = 0; i < numerosEqui.length; i++)
            {
                if (numerosEqui[i] <= numero)
                {
                   sb.append(letras[i]);
                   numero -= numerosEqui[i];
                   break;
                }
            }
        }
        return sb.toString();
    }
}
