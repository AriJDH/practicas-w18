package com.dh.demo.api.controller;

import com.dh.demo.api.service.NumeroRomanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( value = {"/romano"})
public class NumeroRomanoController {
    private final NumeroRomanoService service;

    @Autowired
    public NumeroRomanoController(NumeroRomanoService service) {
        this.service = service;
    }

    @GetMapping("/{numeroDecimal}")
    public ResponseEntity<String> getNumeroRomano(@PathVariable Integer numeroDecimal){
        if(numeroDecimal == null || numeroDecimal <= 0 || numeroDecimal > 3999 )
            return ResponseEntity.badRequest().body("Numero erroneo.");
        return ResponseEntity.ok().body(service.getNumeroRomano(numeroDecimal));
    }

}
