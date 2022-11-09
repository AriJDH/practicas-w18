package com.bootcamp.spring.codigomorse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.spring.codigomorse.service.ProcesoCodigoMorse;

@RestController
@RequestMapping("/morse")
public class MorseController {
	
	@Autowired
	ProcesoCodigoMorse procesoCodigoMorse;
	
	@GetMapping("/getCodigo/{cadena}")
	public String getCodigo(@PathVariable String cadena) {
		
		return procesoCodigoMorse.codigoMorseParseado(cadena);
	}

}
