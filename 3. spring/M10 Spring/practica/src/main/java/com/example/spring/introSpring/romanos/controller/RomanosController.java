package com.example.spring.introSpring.romanos.controller;

import com.example.spring.introSpring.romanos.service.RomanosUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    RomanosUtil romanosUtil = new RomanosUtil();

    @Autowired
    public RomanosController(RomanosUtil romanosUtil) {
        this.romanosUtil = romanosUtil;
    }

    @GetMapping("convertirRomano/{decimal}")
    public String convertirRomano(@PathVariable String decimal){
        String romano = romanosUtil.convertirDecimalARomano(decimal);
        System.out.println(romano);
        return romano;
    }
}
