package com.ejerciciospring.ejercicios_spring.practica_spring_p2_vivo.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    @GetMapping("/obtenerPalabra/{codigoMorse}")
    public String obtenerPalabra(@PathVariable  String codigoMorse) {

        String cadenaFinal = "";

        //diccionario
        Map<String, String> equivalencia = this.construirDiccionario();

        //separar codigos morse por palabra
        String[] palabrasMorse = codigoMorse.split("   ");

        int i = 0;

        for (String palabraMorse : palabrasMorse) {

            String[] arregloMorse = palabraMorse.split(" ");

            for (String morse : arregloMorse) {

                for (Map.Entry<String, String> valor : equivalencia.entrySet()) {

                    if (valor.getValue().equals(morse)) {
                        cadenaFinal += valor.getKey();
                    }
                }
            }

            if (i < palabrasMorse.length - 1) {
                cadenaFinal += " ";
            }

            i++;
        }
        return cadenaFinal;
    }

    private Map<String, String> construirDiccionario() {

        Map<String, String> equivalencias = new HashMap<>();

        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("CH", "----");
        equivalencias.put("D", "-..");
        equivalencias.put("E", ".");
        equivalencias.put("F", "..-.");
        equivalencias.put("G", "--.");
        equivalencias.put("H", "....");
        equivalencias.put("I", "..");
        equivalencias.put("J", ".---");
        equivalencias.put("K", "-.-");
        equivalencias.put("L", ".-..");
        equivalencias.put("M", "--");
        equivalencias.put("N", "-.");
        equivalencias.put("Ñ", "--.--");
        equivalencias.put("O", "---");
        equivalencias.put("P", ".--.");
        equivalencias.put("Q", "--.-");
        equivalencias.put("R", ".-.");
        equivalencias.put("S", "...");
        equivalencias.put("T", "-");
        equivalencias.put("U", "..-");
        equivalencias.put("V", "...-");
        equivalencias.put("W", ".--");
        equivalencias.put("X", "-..-");
        equivalencias.put("Y", "-.--");
        equivalencias.put("Z", "--..");
        equivalencias.put("0", "-----");
        equivalencias.put("1", ".----");
        equivalencias.put("2", "..---");
        equivalencias.put("3", "...--");
        equivalencias.put("4", "....-");
        equivalencias.put("5", ".....");
        equivalencias.put("6", "-....");
        equivalencias.put("7", "--...");
        equivalencias.put("8", "---..");
        equivalencias.put("9", "----.");
        equivalencias.put(".", ".-.-.-");
        equivalencias.put(",", "--..--");
        equivalencias.put("?", "..--..");
        equivalencias.put("!", "-.---");

        return equivalencias;
    }
}
