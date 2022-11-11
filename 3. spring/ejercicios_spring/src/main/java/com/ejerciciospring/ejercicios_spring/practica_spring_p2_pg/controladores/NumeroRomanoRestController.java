package com.ejerciciospring.ejercicios_spring.practica_spring_p2_pg.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoRestController {

    @GetMapping("/numeroEnteroRomano/{numeroEntero}")
    public String convertirNumeroEntero(@PathVariable Integer numeroEntero) {

        Integer numeroEnteroTrabajar = numeroEntero;

        if (numeroEntero > 3999) {
            return "No se acepta numeros mayores a 3999";
        }

        //Obtener decimales
        Integer unidades = numeroEnteroTrabajar % 10;
        numeroEnteroTrabajar /= 10;

        Integer decenas = numeroEnteroTrabajar % 10;
        numeroEnteroTrabajar /= 10;

        Integer centenas = numeroEnteroTrabajar % 10;
        numeroEnteroTrabajar /= 10;

        Integer millar = numeroEnteroTrabajar % 10;
        numeroEnteroTrabajar /= 10;

        String numeroRomano = this.obtenerNumeroRomanoMillar(millar);
        numeroRomano += this.obtenerNumeroRomanoCentena(centenas);
        numeroRomano += this.obtenerNumeroRomanoDecena(decenas);
        numeroRomano += this.obtenerNumeroRomanoUnidad(unidades);

        return numeroRomano;
    }

    private String obtenerNumeroRomanoUnidad(Integer unidad) {

        String numeroRomano = "";

        switch (unidad) {

            case 1: numeroRomano = "I";
                break;
            case 2: numeroRomano = "II";
                break;
            case 3: numeroRomano = "III";
                break;
            case 4: numeroRomano = "IV";
                break;
            case 5: numeroRomano = "V";
                break;
            case 6: numeroRomano = "VI";
                break;
            case 7: numeroRomano = "VII";
                break;
            case 8: numeroRomano = "VIII";
                break;
            case 9: numeroRomano = "IX";
                break;
        }

        return numeroRomano;
    }

    private String obtenerNumeroRomanoMillar(Integer millar) {

        String numeroRomano = "";

        switch (millar) {

            case 1: numeroRomano = "M";
                break;
            case 2: numeroRomano = "MM";
                break;
            case 3: numeroRomano = "MMM";
                break;
        }

        return numeroRomano;
    }

    private String obtenerNumeroRomanoCentena(Integer centena) {

        String numeroRomano = "";

        switch (centena) {

            case 1: numeroRomano = "C";
                break;
            case 2: numeroRomano = "CC";
                break;
            case 3: numeroRomano = "CCC";
                break;
            case 4: numeroRomano = "CD";
                break;
            case 5: numeroRomano = "D";
                break;
            case 6: numeroRomano = "DC";
                break;
            case 7: numeroRomano = "DCC";
                break;
            case 8: numeroRomano = "DCCC";
                break;
            case 9: numeroRomano = "CM";
                break;
        }

        return numeroRomano;
    }

    private String obtenerNumeroRomanoDecena(Integer decena) {

        String numeroRomano = "";

        switch (decena) {

            case 1: numeroRomano = "X";
                break;
            case 2: numeroRomano = "XX";
                break;
            case 3: numeroRomano = "XXX";
                break;
            case 4: numeroRomano = "XL";
                break;
            case 5: numeroRomano = "L";
                break;
            case 6: numeroRomano = "LX";
                break;
            case 7: numeroRomano = "LXX";
                break;
            case 8: numeroRomano = "LXXX";
                break;
            case 9: numeroRomano = "XC";
                break;
        }

        return numeroRomano;
    }
}
