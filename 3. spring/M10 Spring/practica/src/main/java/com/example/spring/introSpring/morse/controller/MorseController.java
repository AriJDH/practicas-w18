package com.example.spring.introSpring.morse.controller;
import com.example.spring.introSpring.morse.service.MorseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    MorseUtil morseUtil = new MorseUtil();

    @Autowired
    public MorseController(MorseUtil morseUtil) {
        this.morseUtil = morseUtil;
    }

    @GetMapping("convertirMorse/{morse}")
    public ResponseEntity<?> convertirMorse(@PathVariable String morse){
        String conversion = morseUtil.convertirMorseAEspanol(morse);
        return ResponseEntity.ok().body(conversion);
    }


}
