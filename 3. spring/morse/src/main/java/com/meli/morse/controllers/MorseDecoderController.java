package com.meli.morse.controllers;

import com.meli.morse.domain.MorseDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseDecoderController {
    private MorseDecoder morseDecoder = new MorseDecoder();
    @GetMapping("morseDecode/{value}")
    public String morseDecode(@PathVariable String value){
        return morseDecoder.decode(value);
    }
}
