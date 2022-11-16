package com.example.demo6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HolaRestController {

    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name){
        return "Hola " + name + "!!!";
    }

    @GetMapping("/romanos/{numero}")
    public String numeroRomano(@PathVariable int numero){

        List<Integer> numeros = Arrays.asList(1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1);
        List<String> numerosRomanos = Arrays.asList("M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I");
        String resp = "El número romano es: ";

        while (numero > 0) {
            for (Integer num : numeros) {
                if (numero >= num) {
                    resp += numerosRomanos.get(numeros.indexOf(num));
                    numero -= num;
                    break;
                }
            }
        }
        return resp;
    }

    @GetMapping("/codigomorse/{codigo}")
    public String numeroRomano(@PathVariable String codigo) {

        Map<String, Character> diccionarioMorse = new HashMap<>();
        diccionarioMorse.put(".-", 'A');
        diccionarioMorse.put("-...", 'B');
        diccionarioMorse.put("-.-.", 'C');
        diccionarioMorse.put("-..", 'D');
        diccionarioMorse.put(".", 'E');
        diccionarioMorse.put("..-.", 'F');
        diccionarioMorse.put("--.", 'G');
        diccionarioMorse.put("....", 'H');
        diccionarioMorse.put("..", 'I');
        diccionarioMorse.put(".---", 'J');
        diccionarioMorse.put("-.-", 'K');
        diccionarioMorse.put(".-..", 'L');
        diccionarioMorse.put("--", 'M');
        diccionarioMorse.put("-.", 'N');
        diccionarioMorse.put("---", 'O');
        diccionarioMorse.put(".--.", 'P');
        diccionarioMorse.put("--.-", 'Q');
        diccionarioMorse.put(".-.", 'R');
        diccionarioMorse.put("...", 'S');
        diccionarioMorse.put("-", 'T');
        diccionarioMorse.put("..-", 'U');
        diccionarioMorse.put("...-", 'V');
        diccionarioMorse.put(".--", 'W');
        diccionarioMorse.put("-..-", 'X');
        diccionarioMorse.put("-.--", 'Y');
        diccionarioMorse.put("--..", 'Z');

        diccionarioMorse.put(".----", '1');
        diccionarioMorse.put("..---", '2');
        diccionarioMorse.put("...--", '3');
        diccionarioMorse.put("....-", '4');
        diccionarioMorse.put(".....", '5');
        diccionarioMorse.put("-....", '6');
        diccionarioMorse.put("--...", '7');
        diccionarioMorse.put("---..", '8');
        diccionarioMorse.put("----.", '9');
        diccionarioMorse.put("-----", '0');

        String[] codigoArr = codigo.split(" ");
        String frase = "";

        for (String palabra : codigoArr) {
            if (palabra == ""){
                frase += " ";
            }else {
                frase += diccionarioMorse.get(palabra);
            }
        }
        System.out.println(frase);
        return frase;
    }

    @GetMapping("/morse/{code}")
    public String morse(@PathVariable String code) {

        Map<String, Character> diccionarioMorse = new HashMap<>();
        diccionarioMorse.put(".-", 'A');
        diccionarioMorse.put("-...", 'B');
        diccionarioMorse.put("-.-.", 'C');
        diccionarioMorse.put("-..", 'D');
        diccionarioMorse.put(".", 'E');
        diccionarioMorse.put("..-.", 'F');
        diccionarioMorse.put("--.", 'G');
        diccionarioMorse.put("....", 'H');
        diccionarioMorse.put("..", 'I');
        diccionarioMorse.put(".---", 'J');
        diccionarioMorse.put("-.-", 'K');
        diccionarioMorse.put(".-..", 'L');
        diccionarioMorse.put("--", 'M');
        diccionarioMorse.put("-.", 'N');
        diccionarioMorse.put("---", 'O');
        diccionarioMorse.put(".--.", 'P');
        diccionarioMorse.put("--.-", 'Q');
        diccionarioMorse.put(".-.", 'R');
        diccionarioMorse.put("...", 'S');
        diccionarioMorse.put("-", 'T');
        diccionarioMorse.put("..-", 'U');
        diccionarioMorse.put("...-", 'V');
        diccionarioMorse.put(".--", 'W');
        diccionarioMorse.put("-..-", 'X');
        diccionarioMorse.put("-.--", 'Y');
        diccionarioMorse.put("--..", 'Z');
        diccionarioMorse.put(" ", ' ');

        String res = "";
        String[] palabras = code.split("   ");


        System.out.println(palabras);
        for(String palabra : palabras) {

            ArrayList<String> letras = new ArrayList<String>(Arrays.asList(palabra.split(" ")));

            String s = letras.stream()
                    .map(letra -> diccionarioMorse.get(letra).toString())
                    .reduce("", String::concat);
            res += s + " ";
        }
        System.out.println(res);
        return res.substring(0, res.length() - 1);
    }

}
