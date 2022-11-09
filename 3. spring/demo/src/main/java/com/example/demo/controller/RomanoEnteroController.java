package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class RomanoEnteroController {

    @GetMapping("romano/{name}")
    public String romanoAEntero(@PathVariable String name){
        char[] letras = name.toCharArray();
        Map<String,Integer> num_Romanos = new HashMap<>();
        num_Romanos.put("I",1);
        num_Romanos.put("V",5);
        num_Romanos.put("X",10);
        num_Romanos.put("L",50);
        num_Romanos.put("C",100);
        num_Romanos.put("D",500);
        num_Romanos.put("M",1000);



        int[] numeros = new int[letras.length];

        for (int i=0;i<numeros.length;i++){
            numeros[i] = num_Romanos.get(String.valueOf(letras[i]));

        }


        int resultado = numeros[0];
        int anterior = numeros[0];

        for (int i=1;i<numeros.length;i++){
            if (anterior < numeros[i]){
                resultado = resultado - anterior;
                resultado += numeros[i]-anterior;
            }
            else {
                resultado += numeros[i];

            }
            anterior = numeros[i];
        }






        return String.valueOf(resultado);
    }



}
