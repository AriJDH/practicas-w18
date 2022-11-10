package com.apiromanos.numerosromanos;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosController {
    @GetMapping("/{numero}")
    public String convertidor(@PathVariable Integer numero) {  //numero será el numero entero que quiero convertir

        int numero2 = numero;
        StringBuilder numeroConvertido = new StringBuilder();   //Se crea un string con el numero ya convertido a romano

        int[] decimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};   //decimales para comparar
        String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  //los romanos de estos decimales en ese orden


        for (int i = 0; i < decimales.length; i++) {  //Para ir recorriendo a los decimales
            System.out.println("i: " + i);
            for (; numero >= decimales[i]; numero -= decimales[i]) {    //El va comparando hasta que mi numero sea mayor a uno de esos.
                                                                        //Cuando sea mayor, pongo ese decimal al que superó en romano
                                                                        //y le resto a mi numero ese valor decimal que ya convertí
                                                                        //Sigo comparando ahora lo que quedo de la resta y repito
                                                                        //Repito hasta que ya comparé con todos los decimales
                numeroConvertido.append(romanos[i]);
            }
        }
        return "El numero " + numero2 + " en romanos es "+ numeroConvertido.toString();
    }
}
