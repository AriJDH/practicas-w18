package com.example.NumerosRomanos.APIcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Romanos {

    @GetMapping("intToRomano/{numero}")
    public String intToRomano(@PathVariable int numero){

        Integer unit, ten, hundred, thousand;
        String unitS = "", tenS = "", hundredS = "", thousandS = "";
        String numFinal = "";
        boolean error = false;

        if (numero > 3999){
            error = true;
        }
        // Divido el num en partes
        unit = numero % 10;
        ten = numero / 10 % 10;
        hundred = numero / 100 % 10;
        thousand = numero / 1000 % 10;



        for(int i = 0; i < 4; i++){
            switch (i){
                case 0:
                    switch (unit){
                        case 0 : unitS = ""; break;
                        case 1 : unitS = "I"; break;
                        case 2 : unitS = "II"; break;
                        case 3 : unitS = "III"; break;
                        case 4 : unitS = "IV"; break;
                        case 5 : unitS = "V"; break;
                        case 6 : unitS = "VI"; break;
                        case 7 : unitS = "VII"; break;
                        case 8 : unitS = "VIII"; break;
                        case 9 : unitS = "IX"; break;
                    }
                    break;
                case 1:
                    switch (ten){
                        case 0 : tenS = ""; break;
                        case 1 : tenS = "X"; break;
                        case 2 : tenS = "XX"; break;
                        case 3 : tenS = "XXX"; break;
                        case 4 : tenS = "XL"; break;
                        case 5 : tenS = "L"; break;
                        case 6 : tenS = "LX"; break;
                        case 7 : tenS = "LXX"; break;
                        case 8 : tenS = "LXXX"; break;
                        case 9 : tenS = "XC"; break;
                    }
                    break;
                case 2:
                    switch (hundred){
                        case 0 : hundredS = ""; break;
                        case 1 : hundredS = "C"; break;
                        case 2 : hundredS = "CC"; break;
                        case 3 : hundredS = "CCC"; break;
                        case 4 : hundredS = "CD"; break;
                        case 5 : hundredS = "D"; break;
                        case 6 : hundredS = "DC"; break;
                        case 7 : hundredS = "DCC"; break;
                        case 8 : hundredS = "DCCC"; break;
                        case 9 : hundredS = "CM"; break;
                    }
                    break;
                case 3:
                    switch (thousand){
                        case 0 : thousandS = ""; break;
                        case 1 : thousandS = "M"; break;
                        case 2 : thousandS = "MM"; break;
                        case 3 : thousandS = "MMM"; break;
                    }

            }
        }


        numFinal = thousandS + hundredS + tenS + unitS;


        if (error){
            return "ERROR: numero mayor a 3999";
        } else {
            return numFinal;
        }


    }

}
