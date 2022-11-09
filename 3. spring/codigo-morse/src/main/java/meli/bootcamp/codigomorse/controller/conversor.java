package meli.bootcamp.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class conversor {

    @GetMapping("/{cadena}")
    public String convertirAMorse(@PathVariable("cadena") String cadena)
    {
        StringBuilder sb = new StringBuilder();
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '0', '?', '!', '.', ','};
        String[] morseEquivalente = {".-", "-..", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "---", "-..", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", "-..-", "-.--",
                "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
                "..--..", "-.-.--", ".-.-.-", "--..--"};

        for (int i = 0; i < cadena.length(); i++)
        {
            char letra = cadena.charAt(i);
            for (int j = 0; j < abecedario.length; j++)
            {
                if (letra == abecedario[j])
                {
                    sb.append(morseEquivalente[j]);
                    break;
                }
            }
        }
       return sb.toString();
    }
}
