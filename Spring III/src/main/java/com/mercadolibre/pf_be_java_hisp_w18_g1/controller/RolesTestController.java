package com.mercadolibre.pf_be_java_hisp_w18_g1.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RolesTestController {
    @GetMapping("/agent")
    public String authAgent(Authentication authentication){
        return "agent: " + authentication.getName() + " - " + authentication.getAuthorities();
    }
    @GetMapping("/agent2")
    public String authAgent2(Authentication authentication){
        return "agent: " + authentication.getName() + " - " + authentication.getAuthorities();
    }
    @GetMapping("/buyer")
    public String authBuyer(Authentication authentication){
        return "buyer: " + authentication.getName() + " - " + authentication.getAuthorities();
    }
    @GetMapping("/buyer2")
    public String authBuyer2(Authentication authentication){
        return "buyer: " + authentication.getName() + " - " + authentication.getAuthorities();
    }
}
