package com.bootcampw18.numerosromanos.service;

import java.util.*;

public class Conversor {
    Map<Character, Integer> ROMANOS = new HashMap<>();

    public Conversor() {
        ROMANOS.put('I', 1);
        ROMANOS.put('V', 5);
        ROMANOS.put('X', 10);
        ROMANOS.put('L', 50);
        ROMANOS.put('C', 100);
        ROMANOS.put('D', 500);
        ROMANOS.put('M', 1000);
    }

    public Integer convertirNroRomanoADecimal(String nroRomano) {
        Integer resultado = 0;
        char[] array = nroRomano.toUpperCase().toCharArray();
        Integer maximoValor = 0;
        Integer actualValor;
        for (int i = array.length - 1; i >= 0; i--) {
            actualValor = ROMANOS.get(array[i]);
            if (actualValor >= maximoValor) {
                resultado += actualValor;
                maximoValor = actualValor;
            } else {
                resultado -= actualValor;
            }
        }
        return resultado;
    }

    public String convertirNroDecimalARomano(Integer nroDecimal) {
        String resultado = "";
        Integer division;
        List<Integer> valores = Arrays.asList(1000,500,100,50,10,5,1);
        List<Character> letras = Arrays.asList('M','D','C','L','X','V','I');

        while (nroDecimal>=valores.get(0)) {
            resultado += letras.get(0);
            nroDecimal -= 1000;
        }
        for (int i=2 ; i<valores.size(); i+=2) {
            division = nroDecimal / valores.get(i);
            if (division != 0) {
                switch (division) {
                    case 9:
                        resultado+=letras.get(i);
                        resultado+=letras.get(i-2);
                        break;
                    case 8: case 7: case 6: case 5:
                        resultado+=letras.get(i-1);
                        for (int j = 0; j < division-5; j++) {
                            resultado+=letras.get(i);
                        }
                        break;
                    case 4:
                        resultado+=letras.get(i);
                        resultado+=letras.get(i-1);
                        break;
                    case 3: case 2: case 1:
                        for (int j = 0; j < division; j++) {
                            resultado+=letras.get(i);
                        }
                        break;
                }
                nroDecimal-= valores.get(i)*division;
            }
        }
        return resultado;
    }
}
