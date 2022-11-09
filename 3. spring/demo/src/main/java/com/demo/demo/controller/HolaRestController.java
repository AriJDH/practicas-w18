package com.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {
	
	@GetMapping("/hello")
	public String hello(){
		return "Hola Wave 18";
	}
}
