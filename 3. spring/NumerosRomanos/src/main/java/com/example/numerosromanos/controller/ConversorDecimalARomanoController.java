package com.example.numerosromanos.controller;
import com.example.numerosromanos.model.ConversorDecimalARomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorDecimalARomanoController {

    @GetMapping("convertirARomano/{num}")
    public String convertirARomano(@PathVariable Integer num){
        return ConversorDecimalARomano.convertirDecimalARomano(num.intValue());
    }
}
