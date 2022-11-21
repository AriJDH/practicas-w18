package com.playground.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class HealthController {
    private IHealthService service;
    /* Ver sintomas cargados */

    @GetMapping("/findSympton")
    public ResponseEntity<List<?>> showAllSintoms(){
        //TODO
        return null;
    }

    @GetMapping("/findSympton/{name}")
    public ResponseEntity
    }
}
